package com.example.tinkoff_hr.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tinkoff_hr.data.entities.restaurant.CacheStatusEntity
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantEntityForDB
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantReviewEntityForDB

@Database(
    entities = [
        RestaurantReviewEntityForDB::class,
        RestaurantEntityForDB::class,
        CacheStatusEntity::class
    ],
    version = 3
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun restaurantReviewsDao(): RestaurantReviewsDao

    abstract fun restaurantsDao(): RestaurantsDao

    abstract fun cachesStatusDao(): CachesStatusDao

}