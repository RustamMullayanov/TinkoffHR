package com.example.tinkoff_hr.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class WorkerEntityForApi(

    @SerialName("employee_id")
    val id: String,

    @SerialName("email")
    val email: String,

    @SerialName("name")
    val name: String,

    @SerialName("surname")
    val surname: String,

    @SerialName("patronymic")
    val patronymic: String? = null,

    @SerialName("photo_url")
    val urlPhoto: String? = null,

    @SerialName("project")
    val project: String,

    @SerialName("table_id")
    val table: String,

    @SerialName("function")
    val function: String,

    @SerialName("about_worker")
    val about: String,

    @SerialName("status")
    val status: Boolean = true,

    @SerialName("state_id")
    val state_id: String,

    @SerialName("permission_id")
    val permission_id: String
)