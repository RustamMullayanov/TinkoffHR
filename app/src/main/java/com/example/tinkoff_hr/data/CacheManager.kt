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

class CacheManager @Inject constructor(private val cachesStatusDao: CachesStatusDao) {

    fun isCacheActual(tableName: String): Single<Boolean> {
        return cachesStatusDao.getCacheStatusByTableName(tableName)
            .toSingle()
            .map { cacheStatus ->
                LocalDateTime(cacheStatus.cachingDate).plusMinutes(30) > LocalDateTime.now()
            }
            .onErrorReturnItem(false)
    }

    fun updateCacheStatus(tableName: String, date: Long) {
        cachesStatusDao.saveCacheStatus(CacheStatusEntity(tableName, date))
    }
}
