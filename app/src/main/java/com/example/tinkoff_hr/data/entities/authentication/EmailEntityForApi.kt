package com.example.tinkoff_hr.data.entities.authentication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class EmailEntityForApi(
    @SerialName("email")
    val email: String
)