package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.data.dto.toDb
import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.domain.repositories_interface.WorkerRepository
import javax.inject.Inject

class WorkerRepositoryImpl @Inject constructor() : WorkerRepository {
    private val workers: List<Worker> = listOf(
        Worker(
            "test1@tin.koff",
            "Рустам",
            "Муллаянов",
            "Радикович",
            "todo",
            "тинькофф ТРЦ",
            1,
            "мобильный разработчик",
            "20 лет",
            "в работе"
        ),
        Worker(
            "test2@tin.koff",
            "Андрей",
            "Крыш",
            "Константинович",
            "todo",
            "тинькофф ТРЦ",
            2,
            "мобильный разработчик",
            "люблю Warface",
            "в работе"
        ),
        Worker(
            "test3@tin.koff",
            "Петр",
            "Петров",
            "Петрович",
            "todo",
            "не тинькофф ТРЦ",
            3,
            "что-то делает",
            "19 лет",
            "в работе"
        )
    )

    override fun getWorkerInfoByEmail(email: String): Worker {
        // хардкод для теста
        return workers.first { worker -> worker.email == email }
        //TODO("Not yet implemented")
    }

    override fun getWorkersInfo(): List<Worker> {
        return workers
        //TODO("Not yet implemented")
    }

    override fun updateWorkerInfo(worker: Worker): Boolean {
        val workerDB = worker.toDb()
        //TODO("Not yet implemented")

        //хардкод для теста
        if (worker.name != "Rustam")
            return false
        return true
    }
}