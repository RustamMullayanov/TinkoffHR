package com.example.tinkoff_hr.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UpdatedWorkerInfoForApi(
    @SerialName("about_worker")
    val about: String,

    @SerialName("function")
    val function: String,

    @SerialName("project")
    val project: String,

    @SerialName("status")
    val status: Boolean = true,

    @SerialName("table_id")
    val table: String,

    @SerialName("state_id")
    val state_id: String,

    @SerialName("permission_id")
    val permission_id: String
)