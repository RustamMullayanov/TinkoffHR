package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.data.api.RetrofitService
import com.example.tinkoff_hr.data.dto.toDomain
import com.example.tinkoff_hr.data.entities.UpdatedWorkerInfoForApi
import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.entities.worker.WorkerStatus
import com.example.tinkoff_hr.domain.repositories_interface.WorkerRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class WorkerRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitService
) : WorkerRepository {
    private val workers: List<Worker> = listOf(
        Worker(
            1,
            "test1@tin.koff",
            "Рустам",
            "Муллаянов",
            "Радикович",
            "todo",
            1,
            1,
            "мобильный разработчик",
            "20 лет",
            WorkerStatus.ACTIVE
        ),
        Worker(
            2,
            "test2@tin.koff",
            "Андрей",
            "Крыш",
            "Константинович",
            "todo",
            1,
            2,
            "мобильный разработчик",
            "люблю Warface",
            WorkerStatus.ACTIVE
        )
    )

    override fun getWorkerInfoById(id: Long): Single<Worker> {
        return retrofitService.getWorkerById(id.toString())
            .map { worker -> worker.toDomain() }
    }

    override fun getWorkerInfoByEmail(email: String): Single<Worker> {
        TODO("Not yet implemented")
    }

    override fun getWorkersInfo(): Single<List<Worker>> {
        return retrofitService.getWorkersList().asSingle()
            .map { list -> list.map { it.toDomain() } }
    }

    override fun searchWorkerInfoByName(searchedText: String): List<Worker> {
        return workers.filter { worker ->
            "${worker.surname} ${worker.name}".contains(searchedText)
        }
    }

    override fun updateWorkerInfo(id: Int, worker: UpdatedWorkerInfoForApi): Completable {
        return retrofitService.updateWorkerById(id.toString(), worker).asCompletable()
    }
}