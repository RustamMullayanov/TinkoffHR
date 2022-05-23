package com.example.tinkoff_hr.data

import com.example.tinkoff_hr.data.dao.CachesStatusDao
import com.example.tinkoff_hr.data.dao.RestaurantReviewsDao
import com.example.tinkoff_hr.data.dao.RestaurantsDao
import com.example.tinkoff_hr.data.dto.toDb
import com.example.tinkoff_hr.data.entities.restaurant.*
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import io.reactivex.Single
import org.joda.time.DateTime
import org.joda.time.LocalDateTime
import javax.inject.Inject

class CacheManager @Inject constructor(
    private val restaurantReviewsDao: RestaurantReviewsDao,
    private val restaurantsDao: RestaurantsDao,
    private val cachesStatusDao: CachesStatusDao
) {

    fun isCacheActual(tableName: String): Single<Boolean> {
        return cachesStatusDao.getCacheStatusByTableName(tableName)
            .toSingle()
            .map { cacheStatus ->
                LocalDateTime(cacheStatus.cachingDate).plusMinutes(30) > LocalDateTime.now()
            }
            .onErrorReturnItem(false)
    }

    fun updateRestaurantsCache(restaurants: List<Restaurant>) {
        restaurantsDao.cachedRestaurants(restaurants.map { it.toDb() })
        updateCacheStatus(RestaurantEntityForDB.TABLE_NAME, DateTime.now().millis)
    }

    fun updateRestaurantReviewsCache(
        restaurantId: String,
        restaurantReviews: List<RestaurantReview>
    ) {
        restaurantReviewsDao.cachedRestaurantsReviews(restaurantReviews.map { it.toDb() })
        updateCacheStatus(
            RestaurantReviewEntityForDB.TABLE_NAME + restaurantId,
            DateTime.now().millis
        )
    }

    private fun updateCacheStatus(tableName: String, date: Long) {
        cachesStatusDao.saveCacheStatus(CacheStatusEntity(tableName, date))
    }
}
