package com.example.tinkoff_hr.domain.entities.restaurant

class RestaurantReview(
    val id: Int,
    val workerEmail: String,
    val text: String,
    val pros: String,
    val cons: String
)