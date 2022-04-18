package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.data.api.RetrofitServiceRestaurants
import com.example.tinkoff_hr.data.api.RetrofitServiceWorkers
import com.example.tinkoff_hr.data.dto.toDomain
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantReviewEntityForApi
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import com.example.tinkoff_hr.domain.repositories_interface.RestaurantRepository
import io.reactivex.Single
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitServiceRestaurants
) : RestaurantRepository {
    private val restaurants: List<Restaurant> = listOf(
        Restaurant(
            "1", "Своя компания", 4.5, true, 500.0,
            56.83369492735619, 60.60067545372085
        ),
        Restaurant(
            "2", "А ты где?", 4.1, false, 365.0,
            56.84363650463943, 60.64473482972403
        )
    )

    private val reviews: List<RestaurantReview> = listOf(
        RestaurantReview(
            "1", "test1@tin.koff", 5.0, "1", "все отлично"
        ),
        RestaurantReview(
            "2", "test2@tin.koff", 5.0, "1", "пойдет"
        )
    )

    override fun getRestaurantInfoById(id: String): Single<Restaurant> {
        return retrofitService.getRestaurantById(id).asSingle()
            .map { restaurant -> restaurant.toDomain() }
    }

    override fun getRestaurantsInfo(): Single<List<Restaurant>> {
        return retrofitService.getRestaurantsList().asSingle()
            .map { list -> list.map { it.toDomain() } }
    }

    override fun getReviewsInfoByRestaurantId(id: String): Single<List<RestaurantReview>> {
        return retrofitService.getRestaurantsReviewsList(id).asSingle()
            .map { list -> list.map { it.toDomain() } }
    }

    override fun saveRestaurantReview(
        restaurantId: String,
        reviewApi: RestaurantReviewEntityForApi
    ): Single<RestaurantReview> {
        return retrofitService.saveRestaurantReview(restaurantId, reviewApi).asSingle()
            .map { review -> review.toDomain() }
    }
}