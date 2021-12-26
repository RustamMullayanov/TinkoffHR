package com.example.tinkoff_hr.domain.repositories_interface

import com.example.tinkoff_hr.domain.entities.worker.Worker
import io.reactivex.Single

interface WorkerRepository {
    fun getWorkerInfoById(id: Long): Single<Worker>

    fun getWorkerInfoByEmail(email: String): Single<Worker>

    fun getWorkersInfo(): Single<List<Worker>>

    fun searchWorkerInfoByName(searchedText: String): List<Worker>

    fun updateWorkerInfo(worker: Worker): Boolean
}