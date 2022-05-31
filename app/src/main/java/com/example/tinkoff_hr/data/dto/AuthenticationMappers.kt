package com.example.tinkoff_hr.data.dto

import com.example.tinkoff_hr.data.entities.authentication.TokenEntityForApi
import com.example.tinkoff_hr.domain.entities.Token

fun TokenEntityForApi.toDomain(): Token =
    Token(
        token = this.token,
        isRegistered = this.isRegistered
    )