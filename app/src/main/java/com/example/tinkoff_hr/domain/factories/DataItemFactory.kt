package com.example.tinkoff_hr.domain.factories

import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.entities.worker.WorkerItem
import javax.inject.Inject

class DataItemFactory @Inject constructor() {

    fun createWorkerItems(workers: List<Worker>): List<WorkerItem> {
        return workers.map { worker -> worker.toListItem() }
    }

    private fun Worker.toListItem(): WorkerItem =
        WorkerItem(
            id = this.id,
            name = this.name,
            surname = this.surname,
            patronymic = this.patronymic,
            photo = this.photo,
            project = this.project,
            function = this.function,
        )
}