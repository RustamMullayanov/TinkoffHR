package com.example.tinkoff_hr.domain.usecases

import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.domain.repositories_interface.WorkerRepository
import javax.inject.Inject

class GetWorkerInfoByEmailUseCase @Inject constructor(private val workerRepository: WorkerRepository) {
    operator fun invoke(email: String): Worker{
        return workerRepository.getWorkerInfoByEmail(email);
    }
}