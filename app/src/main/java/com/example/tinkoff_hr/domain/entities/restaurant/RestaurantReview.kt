package com.example.tinkoff_hr.domain.entities.restaurant

class RestaurantReview(
    val id: String,
    val workerId: String,
    val workerFullName: String,
    val restaurantId: String,
    val text: String,
    val pros: String,
    val cons: String
)