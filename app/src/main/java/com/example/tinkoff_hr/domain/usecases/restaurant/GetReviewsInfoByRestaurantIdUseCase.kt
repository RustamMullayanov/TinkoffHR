package com.example.tinkoff_hr.domain.usecases.restaurant

import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import com.example.tinkoff_hr.domain.repositories_interface.RestaurantRepository
import io.reactivex.Single
import javax.inject.Inject

class GetReviewsInfoByRestaurantIdUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) {
    operator fun invoke(id: Int): Single<List<RestaurantReview>> {
        return restaurantRepository.getReviewsInfoByRestaurantId(id)
    }
}