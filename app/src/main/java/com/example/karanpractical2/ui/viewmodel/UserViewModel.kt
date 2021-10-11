package com.example.karanpractical2.ui.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.karanpractical2.R
import com.example.karanpractical2.data.api.Resource
import com.example.karanpractical2.data.model.seller.SellerListResponse
import com.example.karanpractical2.data.repository.AppRepository
import com.example.karanpractical2.utils.AppUtils
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel(
    var application: Application,
    private var appRepository: AppRepository
) : ViewModel() {
    private val _sellerlistResponse = MutableLiveData<Resource<SellerListResponse>>()
    val sellerlistResponse: LiveData<Resource<SellerListResponse>> = _sellerlistResponse

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
    fun getSellerlist() = viewModelScope.launch {
        val params = HashMap<String, String?>()
        params["user_id"] = "11"
        params["user_device_id"] = "2sSt34eyey4eh870uyuijplfkwhj3iohtw3"
        params["access_token"] = "gerge4yehd45uyr5r5uhrhe4herhdrhe4yeh"
        params["language"] = "en"
        params["user_type"] = "buyer"
        params["barcode"] = "1"
        params["code_name"] = "test"
        params["city"] = "ahmedabad"
        params["state"] = "Gujarat"
        params["country"] = "India"
        params["latitude"] = "23.4585"
        params["latitude"] = "724696"
        params["page"] = "1"



        getSellerData(params)
    }

    //get  call
    private suspend fun getSellerData(params: java.util.HashMap<String, String?>) {
        _sellerlistResponse.postValue(Resource.Loading())
        if (AppUtils.hasInternetConnection(application)) {
            val response = appRepository.getSellerlstRepository(params)
            _sellerlistResponse.postValue(handleResponse(response))
        } else {
            _sellerlistResponse.postValue(Resource.Error(application.getString(R.string.no_internet_connection)))
        }
    }

    // handle response
    private fun handleResponse(response: Response<SellerListResponse>): Resource<SellerListResponse>? {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        } else if (response.errorBody() != null) {
            AppUtils.getErrorMessage(response.errorBody()!!)?.let { it1 ->
                return Resource.Error(it1)
            }
        }
        return Resource.Error(response.message())
    }
}