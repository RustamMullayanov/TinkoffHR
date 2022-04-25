package com.example.tinkoff_hr.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantReviewEntityForDB
import io.reactivex.Single

@Dao
interface RestaurantReviewsDao {

    @Query("SELECT * FROM ${RestaurantReviewEntityForDB.TABLE_NAME}")
    fun getAllCachedRestaurantsReviews(): Single<List<RestaurantReviewEntityForDB>>

    @Query("SELECT * FROM ${RestaurantReviewEntityForDB.TABLE_NAME} WHERE restaurant_id = :restaurantId")
    fun getCachedRestaurantsReviews(restaurantId: String): Single<List<RestaurantReviewEntityForDB>>

    @Insert(entity = RestaurantReviewEntityForDB::class, onConflict = OnConflictStrategy.REPLACE)
    fun cachedRestaurantsReviews(reviews: List<RestaurantReviewEntityForDB>)

}