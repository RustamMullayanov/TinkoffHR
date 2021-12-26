package com.example.api.common.api.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(EnvelopeSerializer::class)
class Envelope<T>(

    @SerialName("data")
    val data: T? = null,

    // TODO когда договоритесь о формате ошибки, нужно будет явно определить класс,
    // в который она будет каститься, вместо стринга
    @SerialName("errorMessage")
    val errorMessage: String? = null
)