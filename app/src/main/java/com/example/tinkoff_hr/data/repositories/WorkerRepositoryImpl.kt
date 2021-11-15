package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.data.dto.toDb
import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.domain.repositories_interface.WorkerRepository

class WorkerRepositoryImpl: WorkerRepository {
    override fun getWorkerInfoByEmail(email: String): Worker {
        // хардкод для теста
        return Worker(
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

    }

    override fun updateWorkerInfo(worker: Worker): Boolean {
        val workerDB = worker.toDb()

        return true
    }
}