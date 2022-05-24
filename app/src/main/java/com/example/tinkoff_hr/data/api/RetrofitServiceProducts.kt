package com.example.tinkoff_hr.data.api

import com.example.api.common.api.base.EnvelopeCall
import com.example.tinkoff_hr.data.entities.orders.ProductEntityForApi
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitServiceProducts {

    @GET("/api/faq/products")
    fun getProductsList(): EnvelopeCall<List<ProductEntityForApi>>

    @GET("/api/faq/products/{id}")
    fun getProductById(@Path("id") id: String): EnvelopeCall<ProductEntityForApi>
}