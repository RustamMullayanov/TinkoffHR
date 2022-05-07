package com.example.tinkoff_hr.ui.where_eat.eatery_information

import com.example.tinkoff_hr.ui.tribute.item.BaseListItem

data class RestaurantReviewItem(
    override val id: String,
    val workerId: String,
    val rating: Double,
    val restaurantId: String,
    val text: String,
    val workerName: String? = null,
    val workerSurname: String? = null,
    val workerPatronymic: String? = null
) : BaseListItem
