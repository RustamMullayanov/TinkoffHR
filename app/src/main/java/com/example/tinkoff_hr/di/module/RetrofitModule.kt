package com.example.tinkoff_hr.di.module

import com.example.tinkoff_hr.data.api.RetrofitProvider
import com.example.tinkoff_hr.data.api.RetrofitServiceWorkers
import dagger.Module
import dagger.Provides


@Module
class RetrofitModule {

    @Provides
    fun provideRetrofitService(retrofitProvider: RetrofitProvider): RetrofitServiceWorkers {
        return retrofitProvider.retrofitServiceWorkers
    }
}