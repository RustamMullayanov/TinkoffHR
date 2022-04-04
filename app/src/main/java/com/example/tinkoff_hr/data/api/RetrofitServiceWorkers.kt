package com.example.tinkoff_hr.data.api

import com.example.api.common.api.base.EnvelopeCall
import com.example.tinkoff_hr.data.entities.UpdatedWorkerInfoForApi
import com.example.tinkoff_hr.data.entities.WorkerEntityForApi
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface RetrofitServiceWorkers {

    // Requests for Workers
    @GET("/api/workers")
    fun getWorkersList(): EnvelopeCall<List<WorkerEntityForApi>>

    @GET("/api/workers/{id}")
    fun getWorkerById(@Path("id") id: String): EnvelopeCall<WorkerEntityForApi>

    @PUT("/api/workers/{id}")
    fun updateWorkerById(@Path("id") id: String, @Body worker: UpdatedWorkerInfoForApi) : EnvelopeCall<Unit>
}