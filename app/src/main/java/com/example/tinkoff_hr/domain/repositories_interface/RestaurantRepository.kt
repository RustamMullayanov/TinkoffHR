package com.example.tinkoff_hr.domain.repositories_interface

import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import io.reactivex.Single

interface RestaurantRepository {
    fun getRestaurantInfoById(id: Int): Single<Restaurant>

    fun getRestaurantsInfo(): Single<List<Restaurant>>

    fun getReviewsInfoByRestaurantId(id: Int): Single<List<RestaurantReview>>

    fun saveRestaurantReview(review: RestaurantReview): Boolean
}