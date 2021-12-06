package com.example.tinkoff_hr.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class WorkersEntityForApi(
    @SerialName("workers")
    val workers: List<WorkerEntityForApi>
)
