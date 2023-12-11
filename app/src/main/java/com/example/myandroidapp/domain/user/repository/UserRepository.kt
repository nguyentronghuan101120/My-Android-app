package com.example.myandroidapp.domain.user.repository

interface UserRepository {
  suspend fun getUsers()
}