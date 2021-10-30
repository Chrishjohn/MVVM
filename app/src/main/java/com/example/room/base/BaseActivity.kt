package com.example.room.base

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.room.R
import com.google.android.material.snackbar.Snackbar
import com.jumlascan.ui.dialog.CustomProgressDialog

open class BaseActivity : AppCompatActivity() {

    private var customProgressDialog: CustomProgressDialog? = null

    fun showSnackBarRed(context: Context?, message: String?) {
        try {
            val view =
                (findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup
            val snackbar =
                Snackbar.make(view, message!!, Snackbar.LENGTH_LONG).setActionTextColor(Color.WHITE)
            val viewGroup = snackbar.view as ViewGroup
            viewGroup.setBackgroundColor(ContextCompat.getColor(context!!, R.color.red))
            val viewTv = snackbar.view
            val tv = viewTv.findViewById<TextView>(R.id.snackbar_text)
            tv.setTextColor(ContextCompat.getColor(context, R.color.white))
            tv.maxLines = 5
            snackbar.duration = 2000
            snackbar.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

/*
    fun logout() {
        val mySharedPreferences = MySharedPreferences.getMySharedPreferences()
        mySharedPreferences!!.isLogin = false
        startLoginActivity()
        finish()
      }
*/

    /**
     * SIMPLE SNACKBAR
     */
    fun showSnackBar(context: Context?, message: String?) {
        try {
            val view =
                (findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup
            val snackbar =
                Snackbar.make(view, message!!, Snackbar.LENGTH_LONG).setActionTextColor(Color.WHITE)
            val viewGroup = snackbar.view as ViewGroup
            viewGroup.setBackgroundColor(ContextCompat.getColor(context!!, R.color.red))
            val viewTv = snackbar.view
            val tv = viewTv.findViewById<TextView>(R.id.snackbar_text)
            tv.setTextColor(ContextCompat.getColor(context, R.color.white))
            tv.maxLines = 5
            snackbar.duration = 2000
            snackbar.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun showProgressDialog(ctx: Context) {
        try {
            customProgressDialog = CustomProgressDialog(ctx)
            customProgressDialog!!.show()
            customProgressDialog!!.setCancelable(false)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hideProgressDialog() {
        try {
            if (customProgressDialog != null && customProgressDialog!!.isShowing) {
                customProgressDialog!!.dismiss()
                customProgressDialog = null
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    open fun hideKeyboard(activity: Activity) {
        val imm: InputMethodManager =
            activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = activity.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    val activity: Activity
        get() = this
}