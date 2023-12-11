package com.example.myandroidapp.util.DI

import android.content.Context
import com.example.myandroidapp.data.user.data_source.UserApi
import com.example.myandroidapp.data.user.repository.UserRepositoryImpl
import com.example.myandroidapp.domain.user.repository.UserRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


interface AppModule {
    val userApi: UserApi
    val userRepository: UserRepository
}

class AppModuleImpl(private val appContext:Context) : AppModule {
    override val userApi: UserApi by lazy {
        Retrofit.Builder().baseUrl("http://127.0.0.1:5000/get-users")
            .addConverterFactory(GsonConverterFactory.create()).build().create()
    }
    override val userRepository: UserRepository
       by lazy {
           UserRepositoryImpl(userApi)
       }

}