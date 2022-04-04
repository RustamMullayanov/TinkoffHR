package com.example.tinkoff_hr.domain.usecases

import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.repositories_interface.WorkerRepository
import io.reactivex.Single
import javax.inject.Inject

class GetWorkerInfoByIdUseCase @Inject constructor(private val workerRepository: WorkerRepository) {
    operator fun invoke(id: Long): Single<Worker> {
        return workerRepository.getWorkerInfoById(id)
    }
}