package com.example.tinkoff_hr.data.dto

import com.example.tinkoff_hr.data.entities.WorkerEntityForDB
import com.example.tinkoff_hr.domain.entities.Worker

class WorkerDBToDomain {
    fun execute(workerDB: WorkerEntityForDB): Worker {
        return Worker(workerDB.email,
            workerDB.name,
            workerDB.surname,
            workerDB.patronymic,
            workerDB.urlPhoto,
            workerDB.project,
            workerDB.table,
            workerDB.function,
            workerDB.about,
            workerDB.status)
    }
}