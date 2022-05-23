package com.example.tinkoff_hr.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantEntityForDB
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantEntityForDB.Companion.TABLE_NAME
import io.reactivex.Single

@Dao
interface RestaurantsDao {

    @Query("SELECT * FROM $TABLE_NAME WHERE restaurant_id = :id")
    fun getCachedRestaurantById(id: String): Single<RestaurantEntityForDB>

    @Query("SELECT * FROM $TABLE_NAME")
    fun getCachedRestaurants(): Single<List<RestaurantEntityForDB>>

    @Insert(entity = RestaurantEntityForDB::class, onConflict = OnConflictStrategy.REPLACE)
    fun cachedRestaurants(restaurants: List<RestaurantEntityForDB>)
}