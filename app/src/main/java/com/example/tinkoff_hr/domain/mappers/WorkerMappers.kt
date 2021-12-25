package com.example.tinkoff_hr.domain.mappers

import com.example.tinkoff_hr.data.entities.WorkerEntityForApi
import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.entities.worker.WorkerStatus

fun WorkerEntityForApi.toDomain(): Worker =
    Worker(
        id = this.id,
        email = this.email,
        name = this.name,
        surname = this.surname,
        project = this.project,
        table = this.table,
        function = this.function,
        about = this.about,
        status = WorkerStatus.fromValue(this.status),
    )
