package com.example.myandroidapp.presentation.home.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myandroidapp.domain.user.repository.UserRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val userRepository: UserRepository

): ViewModel() {
    fun getUsers(){
        viewModelScope.launch {
            userRepository.getUsers()
            println("Data ok")
        }
    }
}