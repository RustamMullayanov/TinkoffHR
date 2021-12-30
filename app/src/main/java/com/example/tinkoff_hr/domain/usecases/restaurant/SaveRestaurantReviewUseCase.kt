package com.example.tinkoff_hr.domain.usecases.restaurant

import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import com.example.tinkoff_hr.domain.repositories_interface.RestaurantRepository
import javax.inject.Inject

class SaveRestaurantReviewUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) {
    operator fun invoke(restaurantReview: RestaurantReview): Boolean {
        return restaurantRepository.saveRestaurantReview(restaurantReview)
    }
}