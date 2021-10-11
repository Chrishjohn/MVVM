package com.example.karanpractical2.ui.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.karanpractical2.data.repository.AppRepository
import com.example.karanpractical2.ui.viewmodel.UserViewModel

@Suppress("UNCHECKED_CAST")
class UserViewmodelFactory(
    private val application: Application,
    val appRepository: AppRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(application, appRepository) as T
    }
}