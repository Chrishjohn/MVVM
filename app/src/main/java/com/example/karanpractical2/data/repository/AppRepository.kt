package com.example.karanpractical2.data.repository

import com.example.karanpractical2.data.api.RetrofitClient
import com.google.gson.JsonObject


class AppRepository {


    suspend fun getSellerlstRepository(params: HashMap<String, String?>) =
        RetrofitClient.apiInterface.getSellerlist(params = params)

}
