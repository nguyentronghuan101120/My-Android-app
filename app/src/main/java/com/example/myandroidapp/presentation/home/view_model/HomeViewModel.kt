package com.example.myandroidapp.presentation.home.view_model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myandroidapp.data.user.models.reponses.UserResponse
import com.example.myandroidapp.domain.user.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository

) : ViewModel() {

    private val _state = MutableStateFlow(emptyList<UserResponse>())

    val state: StateFlow<List<UserResponse>> get() = _state
    fun getUsers() {
        viewModelScope.launch {
            try {
                _state.value = userRepository.getUsers()

                Log.d("data ok", _state.value.toString())

            } catch (e: Exception) {

                e.message?.let { Log.d("data ok error", it) }


            }
        }
    }
}