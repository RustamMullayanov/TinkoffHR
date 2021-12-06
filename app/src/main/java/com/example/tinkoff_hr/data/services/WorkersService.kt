package com.example.tinkoff_hr.data.services

import com.example.tinkoff_hr.data.entities.WorkerEntityForApi
import com.example.tinkoff_hr.data.entities.WorkersEntityForApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WorkersService {
    @GET("/api/workers")
    fun getWorkers() : Single<WorkersEntityForApi>

    @GET("/api/workers")
    fun getWorkerByEmail(@Query("email") email: String) : Single<WorkerEntityForApi>
}