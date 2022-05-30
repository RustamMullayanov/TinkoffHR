package com.example.tinkoff_hr.data.entities.restaurant

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = RestaurantEntityForDB.TABLE_NAME)
class RestaurantEntityForDB(

    @PrimaryKey @ColumnInfo(name = "restaurant_id")
    val id: String,

    @ColumnInfo(name = "restaurant_name")
    val name: String,

    @ColumnInfo(name = "restaurant_rating")
    val rating: Double,

    @ColumnInfo(name = "is_have_lunch")
    val isHasLunch: Boolean,

    @ColumnInfo(name = "restaurant_average_cost")
    val averageCost: Double,

    @ColumnInfo(name = "restaurant_latitude")
    val latitude: Double,

    @ColumnInfo(name = "restaurant_longitude")
    val longitude: Double
){
    companion object {
        const val TABLE_NAME = "restaurants"
    }
}