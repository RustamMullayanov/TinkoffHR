package com.example.tinkoff_hr.data.dto

import com.example.tinkoff_hr.data.entities.WorkerEntityForApi
import com.example.tinkoff_hr.data.entities.WorkerEntityForDB
import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.entities.worker.WorkerStatus

fun Worker.toDb(): WorkerEntityForDB =
    WorkerEntityForDB(
        id = this.id,
        email = this.email,
        name = this.name,
        surname = this.surname,
        patronymic = this.patronymic,
        urlPhoto = this.photo,
        project = this.project,
        table = this.table,
        function = this.function,
        about = this.about,
        status = this.status.value
    )

fun WorkerEntityForDB.toDomain(): Worker =
    Worker(
        id = this.id,
        email = this.email,
        name = this.name,
        surname = this.surname,
        patronymic = this.patronymic,
        photo = this.urlPhoto,
        project = this.project,
        table = this.table,
        function = this.function,
        about = this.about,
        status = WorkerStatus.fromValue(this.status)
    )

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