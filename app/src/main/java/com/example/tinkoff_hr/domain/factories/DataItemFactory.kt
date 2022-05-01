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
            email = this.email,
            name = this.name,
            surname = this.surname,
            patronymic = this.patronymic,
            photo = this.photo,
            project = this.project,
            table = this.table,
            function = this.function,
            about = this.about,
            status = this.status,
            permission_id = this.permission_id,
            state_id = this.state_id,
        )
}