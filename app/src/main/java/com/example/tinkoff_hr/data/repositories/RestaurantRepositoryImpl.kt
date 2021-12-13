package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import com.example.tinkoff_hr.domain.repositories_interface.RestaurantRepository
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor() : RestaurantRepository {
    private val restaurants: List<Restaurant> = listOf(
        Restaurant(
            1, "Своя компания", 9.0, true, 500.0,
            56.83369492735619, 60.60067545372085
        ),
        Restaurant(
            2, "А ты где?", 7.5, false, 365.0,
            56.84363650463943, 60.64473482972403
        ),
        Restaurant(
            3, "Вилка Ложка", 6.5, true, 255.0,
            56.83368644477701, 60.59677928362856
        ),
        Restaurant(
            4, "Поль Бейкери", 7.8, true, 428.5,
            56.843442568345885, 60.64431272082221
        ),
        Restaurant(
            5, "Бургер Кинг", 7.0, false, 200.0,
            56.83369994292241, 60.60072929049454
        )
    )

    override fun getRestaurantInfoById(id: Int): Restaurant {
        return restaurants.first { r -> r.id == id }
        //TODO("Not yet implemented")
    }

    override fun getRestaurantsInfo(): List<Restaurant> {
        return restaurants
        //TODO("Not yet implemented")
    }

    override fun getReviewsInfoByRestaurantId(id: Int): List<RestaurantReview> {
        TODO("Not yet implemented")
    }

    override fun saveRestaurantReview(review: RestaurantReview): Boolean {
        TODO("Not yet implemented")
    }
}