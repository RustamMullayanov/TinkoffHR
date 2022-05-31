package com.example.tinkoff_hr.data.entities.authentication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class VerifyUserEntityForApi(

    @SerialName("email")
    val email: String,

    @SerialName("code")
    val code: Int
)