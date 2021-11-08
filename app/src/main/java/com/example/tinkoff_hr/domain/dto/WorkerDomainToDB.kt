package com.example.tinkoff_hr.domain.dto

import com.example.tinkoff_hr.data.entities.WorkerEntityForDB
import com.example.tinkoff_hr.domain.entities.Worker

class WorkerDomainToDB(private val worker: Worker) {
    fun execute(): WorkerEntityForDB {
        return  WorkerEntityForDB(worker.email,
            worker.name,
            worker.surname,
            worker.patronymic,
            worker.photo,
            worker.project,
            worker.table,
            worker.function,
            worker.about,
            worker.status)
    }
}