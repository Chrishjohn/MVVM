package com.example.room.data.repository

import com.example.room.data.api.RetrofitClient


class AppRepository {


    suspend fun getSellerlstRepository(params: HashMap<String, String?>) =
        RetrofitClient.apiInterface.getSellerlist(params = params)

}
