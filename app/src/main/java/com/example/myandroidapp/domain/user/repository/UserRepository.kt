package com.example.myandroidapp.domain.user.repository

import com.example.myandroidapp.data.user.models.reponses.UserResponse

interface UserRepository {
  suspend fun getUsers():List<UserResponse>
}