package com.example.tinkoff_hr

import android.app.Application
import com.example.tinkoff_hr.di.AppComponent
import com.example.tinkoff_hr.di.DaggerAppComponent

class App: Application() {
    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}