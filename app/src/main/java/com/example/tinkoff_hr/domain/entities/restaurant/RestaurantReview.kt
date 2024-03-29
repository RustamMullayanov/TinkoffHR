package com.example.tinkoff_hr.domain.entities.restaurant

data class RestaurantReview(
    val id: String,
    val workerId: String,
    val rating: Double,
    val restaurantId: String,
    val text: String,
    val workerName: String? = null,
    val workerSurname: String? = null,
    val workerPatronymic: String? = null
)
