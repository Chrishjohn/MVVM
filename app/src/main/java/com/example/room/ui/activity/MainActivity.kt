package com.example.room.ui.activity

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room.R
import com.example.room.base.BaseActivity
import com.example.room.data.api.Resource
import com.example.room.data.model.seller.SellerListResponse
import com.example.room.data.repository.room.StudentRoom
import com.example.room.data.room.DatabaseClient
import com.example.room.databinding.ActivityMainBinding
import com.example.room.ui.adapter.CustomAdapter
import com.example.room.ui.adapter.UserAdapter
import com.example.room.ui.dialog.UpdateDialog
import com.example.room.ui.factory.UserViewmodelFactory
import com.example.room.ui.viewmodel.UserViewModel
import com.example.room.utils.AppUtils
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import java.util.concurrent.Executors


class MainActivity : BaseActivity(), KodeinAware {
    private lateinit var binding: ActivityMainBinding
    override val kodein: Kodein by kodein()
    var linerLayoutManager: LinearLayoutManager? = null
    private lateinit var userViewModel: UserViewModel
    private val factory: UserViewmodelFactory by instance()
    var userlist: List<StudentRoom>? = null
    private lateinit var studentRoom: StudentRoom
    var userAdapter: UserAdapter? = null
    var adapter: CustomAdapter? = null
    private var dialog: UpdateDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            activity,
            R.layout.activity_main
        )
        studentRoom = StudentRoom()

        setupViewModel()
        setupObservers()
        getListApi()
    }

    //get list
    private fun getListApi() {
        @SuppressLint("StaticFieldLeak")
        class GetList : AsyncTask<Void?, Void?, List<StudentRoom>?>() {
            override fun doInBackground(vararg p0: Void?): List<StudentRoom>? {
                userlist = DatabaseClient
                    .getInstance(this@MainActivity)
                    .appDatabase
                    .studentDao()
                    .all as List<StudentRoom>?
                return userlist
            }

            @SuppressLint("SetTextI18n")
            override fun onPostExecute(studentRoomList: List<StudentRoom>?) {
                super.onPostExecute(studentRoomList)
                if (studentRoomList!!.isNotEmpty()) {
                    binding.recyList.setHasFixedSize(true)
                    binding.recyList.layoutManager =
                        LinearLayoutManager(this@MainActivity) //Linear Items
                    adapter = userlist?.let { CustomAdapter(it, this@MainActivity) }
                    binding.recyList.adapter = adapter
                    adapter!!.setOnItemClickLister(object :
                        CustomAdapter.OnItemClickLister {
                        override fun itemClicked(view: View?, position: Int) {
                            dialog = UpdateDialog(activity)
                            dialog!!.show()
                            dialog!!.et_email!!.setText(studentRoomList.get(position).email)
                            dialog!!.et_phone!!.setText(studentRoomList.get(position).mobile)
                            dialog!!.et_productname!!.setText(studentRoomList.get(position).product_name)
                            dialog!!.et_name!!.setText(studentRoomList.get(position).seller_name)

                            dialog!!.btn_ok?.setOnClickListener(View.OnClickListener {
                                dialog!!.dismiss()
                                var productname = AppUtils.getText(dialog!!.et_productname!!)
                                var email = AppUtils.getText(dialog!!.et_email!!)
                                var name = AppUtils.getText(dialog!!.et_name!!)
                                var phone = AppUtils.getText(dialog!!.et_phone!!)
                                Executors.newSingleThreadExecutor().execute {
                                    DatabaseClient.getInstance(applicationContext).appDatabase
                                        .studentDao()
                                        .updateUser(
                                            studentRoomList!!.get(position).product_id,
                                            productname,
                                            name,
                                            email,
                                            phone
                                        )

                                }
                                getListApi()
                            })
                            dialog!!.btn_cancel?.setOnClickListener(View.OnClickListener {
                                dialog!!.dismiss()
                            })

                        }
                    })

                } else {
                    //api calling
                    if (AppUtils.isConnectedToInternet(this@MainActivity)) {

                        userViewModel.getSellerlist()
                        //       startActivity(Intent(this,))
                    }

                }
            }
        }

        val gt = GetList()
        gt.execute()
    }

    //set viewmodel
    private fun setupViewModel() {
        userViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)
        binding.viewmodel = userViewModel
    }

    //set observer for currency
    private fun setupObservers() {

        userViewModel.sellerlistResponse.observe(
            this,
            { response ->
                when (response) {
                    is Resource.Success -> {
                        hideProgressDialog()
                        response.data?.let { sellerlistResponse ->
                            retrieveList(sellerlistResponse.data)
                        }
                    }
                    is Resource.Error -> {
                        hideProgressDialog()
                        response.message?.let { message ->
                            showSnackBar(activity, message)
                        }
                    }
                    is Resource.Loading -> {
                        activity?.let { showProgressDialog(it) }
                    }
                }
            })

    }

    private fun retrieveList(data: List<SellerListResponse.Datum>?) {
        linerLayoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.recyList.layoutManager = linerLayoutManager
        userAdapter = data?.let { UserAdapter(it, this) }
        binding.recyList.itemAnimator = DefaultItemAnimator()
        binding.recyList.adapter = userAdapter
        studentFrom(data as ArrayList<SellerListResponse.Datum>)
        userAdapter!!.setOnItemClickLister(object :
            UserAdapter.OnItemClickLister {
            override fun itemClicked(view: View?, position: Int) {
                dialog = UpdateDialog(activity)
                dialog!!.show()
                dialog!!.et_email!!.setText(data.get(position).email)
                dialog!!.et_phone!!.setText(data.get(position).mobile)
                dialog!!.et_productname!!.setText(data.get(position).productName)
                dialog!!.et_name!!.setText(data.get(position).sellerName)
                dialog!!.btn_cancel?.setOnClickListener(View.OnClickListener {
                    dialog!!.dismiss()
                })

                dialog!!.btn_ok?.setOnClickListener(View.OnClickListener {
                    dialog!!.dismiss()
                    var productname = AppUtils.getText(dialog!!.et_productname!!)
                    var email = AppUtils.getText(dialog!!.et_email!!)
                    var name = AppUtils.getText(dialog!!.et_name!!)
                    var phone = AppUtils.getText(dialog!!.et_phone!!)
                    Executors.newSingleThreadExecutor().execute {
                        DatabaseClient.getInstance(applicationContext).appDatabase
                            .studentDao()
                            .updateUser(
                                data!!.get(position).productId,
                                productname,
                                name,
                                email,
                                phone
                            )

                    }
                    getListApi()

                })
            }
        })

    }

    //getting data from database
    private fun studentFrom(list: ArrayList<SellerListResponse.Datum>) {
        @SuppressLint("StaticFieldLeak")
        class StudentFrom : AsyncTask<Void?, Void?, Void?>() {
            override fun doInBackground(vararg p0: Void?): Void? {
                var i = 0
                while (i < list.size) {
                    studentRoom.product_id = list.get(i).productId
                    studentRoom.product_name = list.get(i).productName
                    studentRoom.category_name = list.get(i).categoryName
                    studentRoom.seller_name = list.get(i).sellerName
                    studentRoom.email = list.get(i).email
                    studentRoom.mobile = list.get(i).mobile

                    //adding to database
                    DatabaseClient.getInstance(applicationContext).appDatabase
                        .studentDao()
                        .insert(studentRoom)
                    i++

                }
                return null
            }

            override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
            }
        }

        val st = StudentFrom()
        st.execute()
    }


}