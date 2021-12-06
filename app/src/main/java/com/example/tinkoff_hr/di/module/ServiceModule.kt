package com.example.tinkoff_hr.di.module

import com.example.tinkoff_hr.data.services.WorkersService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    @Provides
    @Singleton
    @ExperimentalSerializationApi
    fun provideRetrofit(httpClient: OkHttpClient): WorkersService = Retrofit.Builder()
        .baseUrl("https:/www.localhost") //пока не знаю какой url, заглушку написал
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .client(httpClient)
        .build()
        .create(WorkersService ::class.java)
}