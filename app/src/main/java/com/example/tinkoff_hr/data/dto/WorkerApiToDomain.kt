package com.example.tinkoff_hr.data.dto

import com.example.tinkoff_hr.data.entities.WorkerEntityForApi
import com.example.tinkoff_hr.domain.entities.Worker

class WorkerApiToDomain(private val workerApi: WorkerEntityForApi) {
    fun execute(): Worker {
        return Worker(workerApi.email,
            workerApi.name,
            workerApi.surname,
            workerApi.patronymic,
            workerApi.urlPhoto,
            workerApi.project,
            workerApi.table,
            workerApi.function,
            workerApi.about,
            workerApi.status)
    }
}