package com.example.tinkoff_hr.data.dto

import com.example.tinkoff_hr.data.entities.UpdatedWorkerInfoForApi
import com.example.tinkoff_hr.data.entities.WorkerEntityForApi
import com.example.tinkoff_hr.data.entities.WorkerEntityForDB
import com.example.tinkoff_hr.domain.entities.worker.UpdatedWorkerInfo
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
        status = this.status.value,
        state_id = this.state_id,
        permission_id = this.permission_id
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
        status = WorkerStatus.fromValue(this.status),
        state_id = this.state_id,
        permission_id = this.permission_id
    )

fun WorkerEntityForApi.toDomain(): Worker =
    Worker(
        id = this.id,
        email = this.email,
        name = this.name,
        surname = this.surname,
        patronymic = this.patronymic,
        project = this.project,
        table = this.table,
        function = this.function,
        about = this.about,
        status = WorkerStatus.fromValue(this.status),
        state_id = this.state_id,
        permission_id = this.permission_id
    )

fun UpdatedWorkerInfo.toApi(): UpdatedWorkerInfoForApi =
    UpdatedWorkerInfoForApi(
        about = this.about,
        function = this.function,
        project = this.project,
    )