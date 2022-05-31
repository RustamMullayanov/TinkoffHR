package com.example.tinkoff_hr.di.module

import com.example.tinkoff_hr.data.api.RetrofitProvider
import com.example.tinkoff_hr.data.api.RetrofitServiceAuthentication
import com.example.tinkoff_hr.data.api.RetrofitServiceRestaurants
import com.example.tinkoff_hr.data.api.RetrofitServiceWorkers
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi


@Module
class RetrofitModule {

    @ExperimentalSerializationApi
    @Provides
    fun provideRetrofitServiceWorkers(retrofitProvider: RetrofitProvider): RetrofitServiceWorkers {
        return retrofitProvider.retrofitServiceWorkers
    }

    @ExperimentalSerializationApi
    @Provides
    fun provideRetrofitServiceRestaurants(retrofitProvider: RetrofitProvider): RetrofitServiceRestaurants {
        return retrofitProvider.retrofitServiceRestaurants
    }

    @ExperimentalSerializationApi
    @Provides
    fun provideRetrofitServiceAuthentication(retrofitProvider: RetrofitProvider): RetrofitServiceAuthentication {
        return retrofitProvider.retrofitServiceAuthentication
    }
}