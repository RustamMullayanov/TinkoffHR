package com.example.tinkoff_hr.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class WorkerEntityForApi(

//    @SerialName("data")
//    val data: String,

    @SerialName("person_id")
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

    @SerialName("project_id")
    val project: String,

    @SerialName("table_id")
    val table: String,

    @SerialName("function_name")
    val function: String,

    @SerialName("about")
    val about: String,

    @SerialName("status")
    val status: Boolean // change to Enum
)