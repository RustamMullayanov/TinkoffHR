package com.example.tinkoff_hr.data

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenHeaderInterceptor @Inject constructor(private val context: Context): Interceptor {

    private lateinit var tokenStorage: UserTokenStorage

    override fun intercept(chain: Interceptor.Chain): Response {
        tokenStorage = UserTokenStorage(context)
        val original = chain.request()
        val builder = original.newBuilder()
        builder.header("Token", "Bearer ${tokenStorage.getUserToken()}")

        val request = builder.method(original.method, original.body)
            .build()
        return chain.proceed(request)
    }
}