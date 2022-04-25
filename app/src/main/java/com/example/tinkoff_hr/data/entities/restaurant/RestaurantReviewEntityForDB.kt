package com.example.tinkoff_hr.data.entities.restaurant

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = RestaurantReviewEntityForDB.TABLE_NAME)
class RestaurantReviewEntityForDB(

    @PrimaryKey @ColumnInfo(name = "review_id")
    val id: String,

    @ColumnInfo(name = "worker_id")
    val workerId: String,

    @ColumnInfo(name = "restaurant_id")
    val restaurantId: String,

    @ColumnInfo(name = "review_rating")
    val rating: Double,

    @ColumnInfo(name = "review_text")
    val text: String,

    @ColumnInfo(name = "worker_name")
    val workerName: String,

    @ColumnInfo(name = "worker_surname")
    val workerSurname: String,

    @ColumnInfo(name = "worker_patronymic")
    val workerPatronymic: String
) {
    companion object {
        const val TABLE_NAME = "restaurant_reviews"
    }
}