package com.example.tinkoff_hr.data.api

import com.example.api.common.api.base.EnvelopeCallAdapterFactory
import com.example.tinkoff_hr.BuildConfig
import com.example.tinkoff_hr.data.TokenHeaderInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Inject

/**
 * A provider class for retrieving instances of api services
 */
class RetrofitProvider @Inject constructor(){

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) })
        .build()

    /*private val httpClientWithToken = OkHttpClient.Builder()
        .addInterceptor(tokenHeaderInterceptor.apply {  })
        .build()*/

    @ExperimentalSerializationApi
    val retrofitServiceWorkers: RetrofitServiceWorkers =
        customRetrofitBuilder(RetrofitServiceWorkers::class.java)

    @ExperimentalSerializationApi
    val retrofitServiceRestaurants: RetrofitServiceRestaurants =
        customRetrofitBuilder(RetrofitServiceRestaurants::class.java)

    @ExperimentalSerializationApi
    val retrofitServiceAuthentication: RetrofitServiceAuthentication =
        customRetrofitBuilder(RetrofitServiceAuthentication::class.java)

    private fun <T> customRetrofitBuilder(retrofitClass: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addCallAdapterFactory(EnvelopeCallAdapterFactory())
            .addConverterFactory(Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType()))
            .client(httpClient)
            .build()
            .create(retrofitClass)
    }
}