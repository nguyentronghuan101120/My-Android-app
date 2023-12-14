package com.example.myandroidapp.presentation.home.view_model

import HomeState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myandroidapp.data.user.models.reponses.UserResponse
import com.example.myandroidapp.domain.user.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import androidx.compose.runtime.State
import kotlinx.coroutines.flow.MutableStateFlow


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,

    ) : ViewModel() {

    private val _state = MutableStateFlow<HomeState<List<UserResponse>>>(HomeState.Loading)
    val users: StateFlow<HomeState<List<UserResponse>>> = _state
    fun getUsers() {
        viewModelScope.launch {
            try {
                _state.value = HomeState.Success(userRepository.getUsers())


            } catch (e: Exception) {

                _state.value = e.message?.let { HomeState.Error(it) }!!


            }
        }
    }
}