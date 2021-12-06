package com.example.tinkoff_hr.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class WorkerEntityForApi(
    @SerialName("email")
    val email: String,

    @SerialName("person_name")
    val name: String,

    @SerialName("person_second_name")
    val surname: String,

    @SerialName("person_patronymic")
    val patronymic: String,

    @SerialName("worker_photo_url")
    val urlPhoto: String,

    @SerialName("project_name")
    val project: String,

    @SerialName("table_id")
    val table: Int,

    @SerialName("function_name")
    val function: String,

    @SerialName("about")
    val about: String,

    @SerialName("status")
    val status: String
)