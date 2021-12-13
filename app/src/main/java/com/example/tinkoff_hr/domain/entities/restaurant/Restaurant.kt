package com.example.tinkoff_hr.domain.entities.restaurant

class Restaurant(
    val id: Int,
    val name: String,
    val rating: Double,
    val isHasLunch: Boolean,
    val averageCost: Double,
    val latitude: Double,
    val longitude: Double
)