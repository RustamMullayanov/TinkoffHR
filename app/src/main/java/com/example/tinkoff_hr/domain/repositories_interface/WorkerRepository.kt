package com.example.tinkoff_hr.domain.repositories_interface

import com.example.tinkoff_hr.data.entities.UpdatedWorkerInfoForApi
import com.example.tinkoff_hr.domain.entities.worker.Worker
import io.reactivex.Completable
import io.reactivex.Single

interface WorkerRepository {
    fun getWorkerInfoById(id: String): Single<Worker>

    fun getWorkerInfoByEmail(email: String): Single<Worker>

    fun getWorkersInfo(): Single<List<Worker>>

    fun searchWorkerInfoByName(searchedText: String): List<Worker>

    fun updateWorkerInfo(id: String, worker: UpdatedWorkerInfoForApi): Completable
}