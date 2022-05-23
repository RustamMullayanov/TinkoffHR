package com.example.tinkoff_hr

import android.app.Application
import com.example.tinkoff_hr.di.AppComponent
import timber.log.Timber

class App : Application() {
    /*companion object {
        lateinit var appComponent: AppComponent
    }*/

    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    /**
     * Initialize Timber logger tree
     */
    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}