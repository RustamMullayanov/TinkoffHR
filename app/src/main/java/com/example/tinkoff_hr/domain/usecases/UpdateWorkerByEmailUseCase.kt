package com.example.tinkoff_hr.domain.usecases

import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.domain.repositories_interface.WorkerRepository

class UpdateWorkerByEmailUseCase(private val workerRepository: WorkerRepository) {
    operator fun invoke(worker: Worker): Boolean {
        return workerRepository.updateWorkerInfo(worker);
    }
}