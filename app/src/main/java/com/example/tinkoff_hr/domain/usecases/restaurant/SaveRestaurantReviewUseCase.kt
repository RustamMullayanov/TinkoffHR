package com.example.tinkoff_hr.domain.usecases.restaurant

import com.example.tinkoff_hr.data.dto.toApi
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import com.example.tinkoff_hr.domain.repositories_interface.RestaurantRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class SaveRestaurantReviewUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) {
    operator fun invoke(restaurantId: String, restaurantReview: RestaurantReview): Completable {
        return restaurantRepository.saveRestaurantReview(restaurantId, restaurantReview.toApi())
    }
}