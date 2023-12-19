package com.example.myandroidapp.data.user.data_source

import com.example.myandroidapp.data.common.BaseResponse
import com.example.myandroidapp.data.user.models.reponses.UserResponse
import retrofit2.http.GET

interface UserApi {
    @GET("users/")
    suspend fun getUsers(): List<UserResponse>
}