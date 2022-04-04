package com.example.tinkoff_hr.domain.usecases

import com.example.tinkoff_hr.data.dto.toApi
import com.example.tinkoff_hr.domain.entities.worker.UpdatedWorkerInfo
import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.repositories_interface.WorkerRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class UpdateWorkerByIdUseCase @Inject constructor(private val workerRepository: WorkerRepository) {
    operator fun invoke(worker: UpdatedWorkerInfo): Completable {
        return workerRepository.updateWorkerInfo(worker.id, worker.toApi());
    }
}