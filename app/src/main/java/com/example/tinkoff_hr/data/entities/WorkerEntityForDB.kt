package com.example.tinkoff_hr.data.entities

class WorkerEntityForDB(
    val id: Long,
    val email: String,
    val name: String,
    val surname: String,
    val patronymic: String? = null,
    val urlPhoto: String? = null,
    val project: Int,
    val table: Int,
    val function: String,
    val about: String,
    val status: Boolean
)