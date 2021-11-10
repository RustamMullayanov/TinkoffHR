package com.example.tinkoff_hr.domain.entities

class Worker(
    val email: String,
    val name: String,
    val surname: String,
    val patronymic: String,
    val photo: String,
    val project: String,
    val table: Int,
    val function: String,
    val about: String,
    val status: String
)