package com.example.tinkoff_hr.data.entities.restaurant

class RestaurantEntityForApi(
    val id: Int,
    val name: String,
    val rating: Double,
    val isHasLunch: Boolean,
    val averageCost: Double,
    val latitude: Double,
    val longitude: Double
)