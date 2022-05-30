package com.example.tinkoff_hr.data.entities.authentication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class TokenEntityForApi(
    @SerialName("token")
    val token: String
)