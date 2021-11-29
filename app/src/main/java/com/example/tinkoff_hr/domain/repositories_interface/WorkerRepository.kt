package com.example.tinkoff_hr.domain.repositories_interface

import com.example.tinkoff_hr.domain.entities.Worker

interface WorkerRepository {
    fun getWorkerInfoByEmail(email: String): Worker

    fun getWorkersInfo(): List<Worker>

    fun searchWorkerInfoByName(searchedText: String) : List<Worker>

    fun updateWorkerInfo(worker: Worker) : Boolean
}