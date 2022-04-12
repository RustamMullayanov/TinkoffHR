package com.example.tinkoff_hr.domain.repositories_interface

import com.example.tinkoff_hr.data.entities.restaurant.RestaurantReviewEntityForApi
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import io.reactivex.Single

interface RestaurantRepository {
    fun getRestaurantInfoById(id: String): Single<Restaurant>

    fun getRestaurantsInfo(): Single<List<Restaurant>>

    fun getReviewsInfoByRestaurantId(id: String): Single<List<RestaurantReview>>

    fun saveRestaurantReview(
        restaurantId: String,
        reviewApi: RestaurantReviewEntityForApi
    ): Single<RestaurantReview>
}