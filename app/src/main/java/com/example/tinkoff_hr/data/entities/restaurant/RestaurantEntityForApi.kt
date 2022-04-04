package com.example.tinkoff_hr.data.entities.restaurant

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class RestaurantEntityForApi(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    val rating: Double? = null,

    @SerialName("business_lunch")
    val isHasLunch: Boolean,

    @SerialName("average_price")
    val averageCost: Double,

    @SerialName("latitude")
    val latitude: Double,

    @SerialName("longitude")
    val longitude: Double
)