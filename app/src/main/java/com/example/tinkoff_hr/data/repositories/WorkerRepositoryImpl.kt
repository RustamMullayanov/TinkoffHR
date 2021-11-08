package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.data.dto.WorkerDomainToDB
import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.domain.repositories_interface.WorkerRepository

class WorkerRepositoryImpl: WorkerRepository {
    override fun getWorkerInfoByEmail(email: String): Worker {
        TODO("Not yet implemented")
    }

    override fun updateWorkerInfo(worker: Worker): Boolean {
        val workerDB = WorkerDomainToDB(worker).execute()
        TODO("Not yet implemented")
    }
}