package com.example.tinkoff_hr.data.services

import com.example.tinkoff_hr.data.entities.WorkerEntityForApi
import com.example.tinkoff_hr.data.entities.WorkersEntityForApi
import io.reactivex.Single
import retrofit2.http.GET

interface WorkersService {
    @GET("/api/workers")
    fun getWorkers() : Single<WorkersEntityForApi>

    @GET("/api/worker/:email")
    fun getWorkerByEmail() : Single<WorkerEntityForApi>
}