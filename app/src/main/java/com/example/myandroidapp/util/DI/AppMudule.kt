package com.example.myandroidapp.util.DI

import com.example.myandroidapp.data.user.data_source.UserApi
import com.example.myandroidapp.data.user.repository.UserRepositoryImpl
import com.example.myandroidapp.domain.user.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideUserApi(): UserApi {
        return Retrofit.Builder().baseUrl("http://127.0.0.1:5000/get-users/").build()
            .create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: UserApi): UserRepository {
        return UserRepositoryImpl(userApi = api)
    }

}