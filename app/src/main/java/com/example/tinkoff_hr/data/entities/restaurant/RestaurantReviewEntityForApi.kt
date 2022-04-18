package com.example.tinkoff_hr.data.entities.restaurant

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class RestaurantReviewEntityForApi(
    @SerialName("review_id")
    val id: String,

    @SerialName("employee_id")
    val workerId: String,

    @SerialName("rating")
    val rating: Double,

    @SerialName("restaurant_id")
    val restaurantId: String,

    @SerialName("text")
    val text: String,

    @SerialName("name")
    val workerName: String? = null,

    @SerialName("surname")
    val workerSurname: String? = null,

    @SerialName("patronymic")
    val workerPatronymic: String? = null
)