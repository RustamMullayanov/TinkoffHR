package com.example.tinkoff_hr.data.entities.restaurant

class RestaurantReviewEntityForApi(
    val id: Int,
    val workerEmail: String,
    val restaurantId: Int,
    val workerFullName: String,
    val text: String,
    val pros: String,
    val cons: String
)