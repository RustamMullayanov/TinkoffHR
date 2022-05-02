package com.example.tinkoff_hr.ui.where_eat

import android.os.Parcelable
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RestaurantItem(
    override val id: String,
    val name: String,
    val rating: Double,
    val latitude: Double,
    val longitude: Double
) : BaseListItem, Parcelable
