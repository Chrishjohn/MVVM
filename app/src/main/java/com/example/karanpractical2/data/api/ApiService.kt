package com.example.karanpractical2.data.api

import com.example.karanpractical2.data.model.seller.SellerListResponse
import com.example.karanpractical2.data.model.trip.TripResponse
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.*


interface ApiService {


    @FormUrlEncoded
    @POST(RestConstant.SellerList)
    suspend fun getSellerlist(@FieldMap params: HashMap<String, String?>): Response<SellerListResponse>

}