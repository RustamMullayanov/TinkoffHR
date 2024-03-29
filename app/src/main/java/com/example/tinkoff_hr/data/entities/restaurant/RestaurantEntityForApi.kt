package com.example.tinkoff_hr.data.entities.restaurant

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class RestaurantEntityForApi(
    @SerialName("id")
    val id: String,

    @SerialName("name")
    val name: String,

    @SerialName("rating")
    val rating: Double,

    @SerialName("business_lunch")
    val isHasLunch: Boolean,

    @SerialName("average_price")
    val averageCost: Double,

    @SerialName("latitude")
    val latitude: Double,

    @SerialName("longitude")
    val longitude: Double
)