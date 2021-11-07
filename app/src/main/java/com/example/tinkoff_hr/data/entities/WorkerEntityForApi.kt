package com.example.tinkoff_hr.data.entities

class WorkerEntityForApi(
    val email: String,
    val name: String,
    val surname: String,
    val patronymic: String,
    val urlPhoto: String,
    val project: String,
    val table: Int,
    val function: String,
    val about: String,
    val status: String
)