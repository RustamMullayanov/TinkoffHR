package com.example.tinkoff_hr.domain.repositories_interface

import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview

interface RestaurantRepository {
    fun getRestaurantInfoById(id: Int): Restaurant

    fun getRestaurantsInfo(): List<Restaurant>

    fun getReviewsInfoByRestaurantId(id: Int): List<RestaurantReview>

    fun saveRestaurantReview(review: RestaurantReview): Boolean
}