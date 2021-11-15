package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.data.dto.toDb
import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.domain.repositories_interface.WorkerRepository

class WorkerRepositoryImpl: WorkerRepository {
    //хардкод для теста
    private var worker = Worker(
        "mymail@tin.koff",
        "Rustam",
        "Mullayanov",
        "Radikovich",
        "todo",
        "тинькофф ТРЦ",
        1,
        "мобильный разработчик",
        "20 лет",
        "в работе"
    )

    override fun getWorkerInfoByEmail(email: String): Worker {
        // хардкод для теста
        return worker
        //TODO("Not yet implemented")
    }

    override fun updateWorkerInfo(worker: Worker): Boolean {
        val workerDB = worker.toDb()
        //TODO("Not yet implemented")

        //хардкод для теста
        if(worker.name != "Rustam")
            return false
        this.worker = worker
        return true
    }
}