package com.example.tinkoff_hr.data.entities.restaurant

class RestaurantReviewEntityForDB(
    val id: String,
    val workerId: String,
    val restaurantId: String,
    val rating: Double,
    val text: String,
    val workerName: String? = null,
    val workerSurname: String? = null,
    val workerPatronymic: String? = null
)