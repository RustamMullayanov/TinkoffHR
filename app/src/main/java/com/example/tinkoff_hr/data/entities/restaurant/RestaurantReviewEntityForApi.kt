package com.example.tinkoff_hr.data.entities.restaurant

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class RestaurantReviewEntityForApi(
    @SerialName("review_id")
    val id: String,

    @SerialName("worker_id")
    val workerId: String,

    @SerialName("worker_full_name")
    val workerFullName: String,

    @SerialName("restaurant_id")
    val restaurantId: String,

    @SerialName("review_text")
    val text: String,
)