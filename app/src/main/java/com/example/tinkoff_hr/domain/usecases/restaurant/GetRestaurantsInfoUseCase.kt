package com.example.tinkoff_hr.domain.usecases.restaurant

import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.domain.repositories_interface.RestaurantRepository
import javax.inject.Inject

class GetRestaurantsInfoUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) {
    operator fun invoke(): List<Restaurant> {
        return restaurantRepository.getRestaurantsInfo()
    }
}