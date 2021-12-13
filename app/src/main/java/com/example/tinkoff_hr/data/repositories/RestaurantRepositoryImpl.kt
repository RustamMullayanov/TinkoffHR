package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import com.example.tinkoff_hr.domain.repositories_interface.RestaurantRepository
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor() : RestaurantRepository {
    override fun getRestaurantInfoById(id: Int): Restaurant {
        TODO("Not yet implemented")
    }

    override fun getRestaurantsInfo(): List<Restaurant> {
        TODO("Not yet implemented")
    }

    override fun getReviewsInfoByRestaurantId(id: Int): List<RestaurantReview> {
        TODO("Not yet implemented")
    }

    override fun saveRestaurantReview(review: RestaurantReview): Boolean {
        TODO("Not yet implemented")
    }
}