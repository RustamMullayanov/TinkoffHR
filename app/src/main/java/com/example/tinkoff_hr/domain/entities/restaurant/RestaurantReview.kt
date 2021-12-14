package com.example.tinkoff_hr.domain.entities.restaurant

class RestaurantReview(
    val id: Int,
    val workerEmail: String, // на случай если придется подгружать данные о worker-е отдельно
    val workerFullName: String,
    val restaurantId: Int,
    val text: String,
    val pros: String,
    val cons: String
)