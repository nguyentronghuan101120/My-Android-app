package com.example.myandroidapp.data.user.repository

import com.example.myandroidapp.data.user.data_source.UserApi
import com.example.myandroidapp.domain.user.repository.UserRepository
import java.lang.Exception

class UserRepositoryImpl(private val userApi: UserApi) :
    UserRepository {
    override suspend fun getUsers() {
        try {
            userApi.getUsers()
        } catch (e: Exception) {
            throw e
        }
    }
}