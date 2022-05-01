package com.example.tinkoff_hr.domain.entities.restaurant

import com.example.tinkoff_hr.ui.tribute.item.BaseListItem

data class RestaurantReview(
    override val id: String,
    val workerId: String,
    val rating: Double,
    val restaurantId: String,
    val text: String,
    val workerName: String? = null,
    val workerSurname: String? = null,
    val workerPatronymic: String? = null
): BaseListItem
