package com.example.myandroidapp.presentation.home.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myandroidapp.domain.user.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository

): ViewModel() {
    fun getUsers(){
        viewModelScope.launch {
//            userRepository.getUsers()
            println("Data ok")
        }
    }
}