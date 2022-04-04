package com.example.tinkoff_hr.di.module

import com.example.tinkoff_hr.data.api.RetrofitProvider
import com.example.tinkoff_hr.data.api.RetrofitServiceRestaurants
import com.example.tinkoff_hr.data.api.RetrofitServiceWorkers
import dagger.Module
import dagger.Provides


@Module
class RetrofitModule {

    @Provides
    fun provideRetrofitServiceWorkers(retrofitProvider: RetrofitProvider): RetrofitServiceWorkers {
        return retrofitProvider.retrofitServiceWorkers
    }

    @Provides
    fun provideRetrofitServiceRestaurants(retrofitProvider: RetrofitProvider): RetrofitServiceRestaurants {
        return retrofitProvider.retrofitServiceRestaurants
    }
}