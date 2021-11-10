package com.example.tinkoff_hr.data.dto

import com.example.tinkoff_hr.data.entities.WorkerEntityForApi
import com.example.tinkoff_hr.data.entities.WorkerEntityForDB
import com.example.tinkoff_hr.domain.entities.Worker

fun Worker.toDb(): WorkerEntityForDB =
    WorkerEntityForDB(
        email = this.email,
        name = this.name,
        surname = this.surname,
        patronymic = this.patronymic,
        urlPhoto = this.photo,
        project = this.project,
        table = this.table,
        function = this.function,
        about = this.about,
        status = this.status
    )

fun WorkerEntityForDB.toDomain(): Worker =
    Worker(
        email = this.email,
        name = this.name,
        surname = this.surname,
        patronymic = this.patronymic,
        photo = this.urlPhoto,
        project = this.project,
        table = this.table,
        function = this.function,
        about = this.about,
        status = this.status
    )

fun WorkerEntityForApi.toDomain(): Worker =
    Worker(
        email = this.email,
        name = this.name,
        surname = this.surname,
        patronymic = this.patronymic,
        photo = this.urlPhoto,
        project = this.project,
        table = this.table,
        function = this.function,
        about = this.about,
        status = this.status
    )