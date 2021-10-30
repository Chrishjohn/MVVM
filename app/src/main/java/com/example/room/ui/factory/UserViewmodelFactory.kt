package com.example.room.ui.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.room.data.repository.AppRepository
import com.example.room.ui.viewmodel.UserViewModel

@Suppress("UNCHECKED_CAST")
class UserViewmodelFactory(
    private val application: Application,
    val appRepository: AppRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(application, appRepository) as T
    }
}