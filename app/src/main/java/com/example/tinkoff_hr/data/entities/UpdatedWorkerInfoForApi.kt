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
)