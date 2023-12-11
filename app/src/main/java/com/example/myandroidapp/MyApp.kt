package com.example.myandroidapp

import android.app.Application
import com.example.myandroidapp.util.DI.AppModule
import com.example.myandroidapp.util.DI.AppModuleImpl

class MyApp : Application() {

    companion object {
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()

        appModule = AppModuleImpl(this)
    }
}