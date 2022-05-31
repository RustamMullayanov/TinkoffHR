package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.data.CacheManager
import com.example.tinkoff_hr.data.api.RetrofitServiceRestaurants
import com.example.tinkoff_hr.data.dao.CachesStatusDao
import com.example.tinkoff_hr.data.dao.RestaurantReviewsDao
import com.example.tinkoff_hr.data.dao.RestaurantsDao
import com.example.tinkoff_hr.data.dto.toDb
import com.example.tinkoff_hr.data.dto.toDomain
import com.example.tinkoff_hr.data.entities.restaurant.CacheStatusEntity
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantEntityForDB
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantReviewEntityForApi
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantReviewEntityForDB
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import com.example.tinkoff_hr.domain.repositories_interface.RestaurantRepository
import dagger.Lazy
import io.reactivex.Completable
import io.reactivex.Single
import org.joda.time.DateTime
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    private val retrofitService: Lazy<RetrofitServiceRestaurants>,
    private val restaurantReviewsDao: RestaurantReviewsDao,
    private val restaurantsDao: RestaurantsDao,
    private val cacheManager: CacheManager
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
        return restaurantsDao.getCachedRestaurantById(id)
            .map { restaurant -> restaurant.toDomain() }
    }

    override fun getRestaurantsInfo(): Single<List<Restaurant>> {
        return cacheManager.isCacheActual(RestaurantEntityForDB.TABLE_NAME)
            .flatMap { cacheActual ->
                if (cacheActual) getRestaurantsFromCache()
                else getRestaurantsFromServer()
            }
    }

    override fun getReviewsInfoByRestaurantId(id: String): Single<List<RestaurantReview>> {
        return cacheManager.isCacheActual(formatReviewsCacheKey(id))
            .flatMap { cacheActual ->
                if (cacheActual) getRestaurantReviewsFromCache(id)
                else getRestaurantReviewsFromServer(id)
            }
    }

    override fun saveRestaurantReview(
        restaurantId: String,
        reviewApi: RestaurantReviewEntityForApi
    ): Completable {
        return retrofitService.get().saveRestaurantReview(restaurantId, reviewApi).asCompletable()
    }

    // Для ресторанов
    private fun getRestaurantsFromServer(): Single<List<Restaurant>> {
        return retrofitService.get().getRestaurantsList().asSingle()
            .map { list -> list.map { it.toDomain() } }
            .doOnSuccess { list -> updateRestaurantsCache(list) }
    }

    private fun getRestaurantsFromCache(): Single<List<Restaurant>> {
        return restaurantsDao.getCachedRestaurants()
            .map { list -> list.map { it.toDomain() } }
    }

    private fun updateRestaurantsCache(restaurants: List<Restaurant>) {
        restaurantsDao.cachedRestaurants(restaurants.map { it.toDb() })
        cacheManager.updateCacheStatus(RestaurantEntityForDB.TABLE_NAME, DateTime.now().millis)
    }

    // Для отзывов о ресторане
    private fun getRestaurantReviewsFromServer(restaurantId: String): Single<List<RestaurantReview>> {
        return retrofitService.get().getRestaurantsReviewsList(restaurantId).asSingle()
            .map { list -> list.map { it.toDomain() } }
            .doOnSuccess { list -> updateRestaurantReviewsCache(restaurantId, list) }
    }

    private fun getRestaurantReviewsFromCache(restaurantId: String): Single<List<RestaurantReview>> {
        return restaurantReviewsDao.getCachedRestaurantsReviews(restaurantId)
            .map { list -> list.map { it.toDomain() } }
    }

    private fun formatReviewsCacheKey(restaurantId: String) =
        RestaurantReviewEntityForDB.TABLE_NAME + restaurantId

    private fun updateRestaurantReviewsCache(
        restaurantId: String,
        restaurantReviews: List<RestaurantReview>
    ) {
        restaurantReviewsDao.cachedRestaurantsReviews(restaurantReviews.map { it.toDb() })
        cacheManager.updateCacheStatus(
            RestaurantReviewEntityForDB.TABLE_NAME + restaurantId,
            DateTime.now().millis
        )
    }
}