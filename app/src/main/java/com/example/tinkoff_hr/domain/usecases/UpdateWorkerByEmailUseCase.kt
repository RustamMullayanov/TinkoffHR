package com.example.tinkoff_hr.domain.usecases

import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.repositories_interface.WorkerRepository
import javax.inject.Inject

class UpdateWorkerByEmailUseCase @Inject constructor(private val workerRepository: WorkerRepository) {
    operator fun invoke(worker: Worker): Boolean {
        return workerRepository.updateWorkerInfo(worker);
    }
}