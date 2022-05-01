package com.example.tinkoff_hr.domain.entities.restaurant

import com.example.tinkoff_hr.ui.tribute.item.BaseListItem

class Restaurant(
    override val id: String,
    val name: String,
    val rating: Double,
    val isHasLunch: Boolean,
    val averageCost: Double,
    val latitude: Double,
    val longitude: Double
) : BaseListItem