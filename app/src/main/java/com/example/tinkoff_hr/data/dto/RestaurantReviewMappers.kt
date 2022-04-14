package com.example.tinkoff_hr.data.dto

import com.example.tinkoff_hr.data.entities.restaurant.RestaurantReviewEntityForApi
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantReviewEntityForDB
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview

fun RestaurantReview.toDb(): RestaurantReviewEntityForDB =
    RestaurantReviewEntityForDB(
        id = this.id,
        workerId = this.workerId,
        workerFullName = this.workerFullName,
        restaurantId = this.restaurantId,
        text = this.text
    )

fun RestaurantReviewEntityForDB.toDomain(): RestaurantReview =
    RestaurantReview(
        id = this.id,
        workerId = this.workerId,
        workerFullName = this.workerFullName,
        restaurantId = this.restaurantId,
        text = this.text
    )

fun RestaurantReviewEntityForApi.toDomain(): RestaurantReview =
    RestaurantReview(
        id = this.id,
        workerId = this.workerId,
        workerFullName = this.workerFullName,
        restaurantId = this.restaurantId,
        text = this.text
    )

fun RestaurantReview.toApi(): RestaurantReviewEntityForApi =
    RestaurantReviewEntityForApi(
        id = this.id,
        workerId = this.workerId,
        workerFullName = this.workerFullName,
        restaurantId = this.restaurantId,
        text = this.text
    )