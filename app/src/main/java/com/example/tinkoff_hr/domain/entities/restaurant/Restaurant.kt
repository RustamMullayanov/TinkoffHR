package com.example.tinkoff_hr.domain.entities.restaurant

data class Restaurant(
    val id: String,
    val name: String,
    val rating: Double,
    val isHasLunch: Boolean,
    val averageCost: Double,
    val latitude: Double,
    val longitude: Double
)