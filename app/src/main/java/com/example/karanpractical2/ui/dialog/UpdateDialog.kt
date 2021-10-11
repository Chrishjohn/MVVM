package com.example.karanpractical2.ui.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.example.karanpractical2.R

  class UpdateDialog (context: Context) : Dialog(context) {
   var et_name: AppCompatEditText? = null
    var et_productname: AppCompatEditText? = null
    var et_email: AppCompatEditText? = null
    var et_phone: AppCompatEditText? = null
    var btn_ok: AppCompatButton? = null
      var btn_cancel: AppCompatButton? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.update_dialog)
        et_name = findViewById(R.id.et_name)
        et_productname = findViewById(R.id.et_product_name)
        et_email = findViewById(R.id.et_email)
        et_phone = findViewById(R.id.et_phone)
        btn_ok = findViewById(R.id.btn_ok)
        btn_cancel = findViewById(R.id.bt_cancel)

    }

    init {
        setCancelable(false)
    }
}