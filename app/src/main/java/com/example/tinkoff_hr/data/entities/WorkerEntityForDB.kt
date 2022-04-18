package com.example.tinkoff_hr.data.entities

class WorkerEntityForDB(
    val id: String,
    val email: String,
    val name: String,
    val surname: String,
    val patronymic: String? = null,
    val urlPhoto: String? = null,
    val project: String,
    val table: String,
    val function: String,
    val about: String,
    val status: Boolean = true,
    val state_id: String,
    val permission_id: String
)