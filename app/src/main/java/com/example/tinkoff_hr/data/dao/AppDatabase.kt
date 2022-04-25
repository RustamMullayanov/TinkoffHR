package com.example.tinkoff_hr.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantReviewEntityForDB

@Database(entities = [RestaurantReviewEntityForDB::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun restaurantReviewsDao(): RestaurantReviewsDao

}