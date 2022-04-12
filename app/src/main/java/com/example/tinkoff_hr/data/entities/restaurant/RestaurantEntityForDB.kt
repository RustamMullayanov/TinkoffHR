package com.example.tinkoff_hr.data.entities.restaurant

class RestaurantEntityForDB(
    val id: String,
    val name: String,
    val rating: Double? = null,
    val isHasLunch: Boolean,
    val averageCost: Double,
    val latitude: Double,
    val longitude: Double
)