@file:Suppress("UNCHECKED_CAST")

package com.example.myandroidapp.presentation.home.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
fun <VM: ViewModel> viewModelFactory(initializer: () -> VM): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return initializer as T
        }
    }
}