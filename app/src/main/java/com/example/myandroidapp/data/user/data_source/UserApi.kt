//package com.example.myandroidapp.data.user.data_source
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object UserApi {
//    private val retrofit = Retrofit.Builder().baseUrl("http://127.0.0.1:5000/get-users")
//        .addConverterFactory(GsonConverterFactory.create()).build()
//
//    val userService: UserService = retrofit.create(UserService::class.java)
//}

package com.example.myandroidapp.data.user.data_source

import com.example.myandroidapp.data.common.BaseResponse
import com.example.myandroidapp.data.user.models.reponses.UserResponse
import retrofit2.http.GET

interface UserApi {
    @GET("getUsers")
    suspend fun getUsers()
}