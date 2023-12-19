package com.example.myandroidapp.data.user.repository

import com.example.myandroidapp.data.user.data_source.UserApi
import com.example.myandroidapp.data.user.models.reponses.UserResponse
import com.example.myandroidapp.domain.user.repository.UserRepository
import java.lang.Exception

class UserRepositoryImpl(private val userApi: UserApi) :
    UserRepository {
    override suspend fun getUsers(): List<UserResponse> {
        try {
            val result = userApi.getUsers()
            return result
        } catch (e: Exception) {
            throw e
        }
    }
}