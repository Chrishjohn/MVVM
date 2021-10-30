package com.example.room.data.api

import com.example.room.data.model.seller.SellerListResponse
import retrofit2.Response
import retrofit2.http.*


interface ApiService {


    @FormUrlEncoded
    @POST(RestConstant.SellerList)
    suspend fun getSellerlist(@FieldMap params: HashMap<String, String?>): Response<SellerListResponse>

}