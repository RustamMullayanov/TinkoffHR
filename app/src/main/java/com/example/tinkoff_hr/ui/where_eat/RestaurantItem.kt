package com.example.tinkoff_hr.ui.where_eat

import com.example.tinkoff_hr.ui.tribute.item.BaseListItem

data class RestaurantItem(
    override val id: String,
    val name: String,
    val rating: Double,
    val latitude: Double,
    val longitude: Double
) : BaseListItem
