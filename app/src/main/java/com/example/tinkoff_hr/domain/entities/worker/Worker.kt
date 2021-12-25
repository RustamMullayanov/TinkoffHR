package com.example.tinkoff_hr.domain.entities.worker

class Worker(
    val id: Long,
    val email: String,
    val name: String,
    val surname: String,
    val patronymic: String? = null,
    val photo: String? = null,
    val project: Int,
    val table: Int,
    val function: String,
    val about: String,
    val status: WorkerStatus
)