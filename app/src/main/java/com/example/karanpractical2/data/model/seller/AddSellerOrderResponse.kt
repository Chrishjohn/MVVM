package com.example.karanpractical2.data.model.seller

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class AddSellerOrderResponse {
    @SerializedName("code")
    @Expose
    var code: String? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

}