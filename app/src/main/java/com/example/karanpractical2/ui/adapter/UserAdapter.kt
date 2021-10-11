package com.example.karanpractical2.ui.adapter

import android.content.Context
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.karanpractical2.R
import com.example.karanpractical2.data.model.seller.SellerListResponse
import com.example.karanpractical2.data.model.trip.TripResponse
import com.example.karanpractical2.data.repository.room.StudentRoom
import com.example.karanpractical2.databinding.ItemListBinding

class UserAdapter(private val list: List<SellerListResponse.Datum>,val context: Context) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private var onItemClickLister: OnItemClickLister? = null

    inner class MyViewHolder(var binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(position: Int) {
            //itemView.setOnClickListener { clickListener(mSectionOrRowModelItem) }
            itemView.apply {
                val data: SellerListResponse.Datum = list[position]
                binding.txtName.setText("Username: "+data.sellerName)
                binding.txtProductName.setText("Product: "+data.productName)
                binding.txtEmail.setText("Email: "+data.email)
                binding.txtMobile.setText("Mobile: +91 "+data.mobile)

            }
        }

        override fun onClick(v: View) {
            if (onItemClickLister != null) {
                onItemClickLister!!.itemClicked(v, adapterPosition)
            }
        }

        init {
            itemView.setOnClickListener(this)
        }
    }


    interface OnItemClickLister {
        fun itemClicked(view: View?, position: Int)
    }

    fun setOnItemClickLister(onItemClickLister: OnItemClickLister?) {
        this.onItemClickLister = onItemClickLister
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_list,
            parent,
            false
        )
        return MyViewHolder(binding as ItemListBinding)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }


    /*fun tripList(list: List<Stud>) {
        this.list.apply {
            clear()
            addAll(list)
        }
    }*/
/*
    fun addProfileImage(profileImage: List<DataItem>) {
        this.profileImage.apply {
            clear()
            addAll(profileImage)
        }
    }
*/

    override fun getItemViewType(position: Int): Int {
        return position
    }
}