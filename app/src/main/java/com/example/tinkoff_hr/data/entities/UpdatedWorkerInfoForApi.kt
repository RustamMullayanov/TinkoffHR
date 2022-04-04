package com.example.tinkoff_hr.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UpdatedWorkerInfoForApi(
    @SerialName("about")
    val about: String,

    @SerialName("function")
    val function: String,

    @SerialName("project_id")
    val project: Int,

    @SerialName("status")
    val status: Boolean,

    @SerialName("table_id")
    val table: Int,
)