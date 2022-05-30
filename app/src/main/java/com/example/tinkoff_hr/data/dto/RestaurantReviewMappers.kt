package com.example.tinkoff_hr.data.dto

import com.example.tinkoff_hr.data.entities.restaurant.RestaurantReviewEntityForApi
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantReviewEntityForDB
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview

fun RestaurantReview.toDb(): RestaurantReviewEntityForDB =
    RestaurantReviewEntityForDB(
        id = this.id,
        workerId = this.workerId,
        restaurantId = this.restaurantId,
        rating = this.rating,
        text = this.text,
        workerName = this.workerName!!,
        workerSurname = this.workerSurname!!,
        workerPatronymic = this.workerPatronymic!!
    )

fun RestaurantReviewEntityForDB.toDomain(): RestaurantReview =
    RestaurantReview(
        id = this.id,
        workerId = this.workerId,
        restaurantId = this.restaurantId,
        rating = this.rating,
        text = this.text,
        workerName = this.workerName,
        workerSurname = this.workerSurname,
        workerPatronymic = this.workerPatronymic
    )

fun RestaurantReviewEntityForApi.toDomain(): RestaurantReview =
    RestaurantReview(
        id = this.id,
        workerId = this.workerId,
        restaurantId = this.restaurantId,
        rating = this.rating,
        text = this.text,
        workerName = this.workerName,
        workerSurname = this.workerSurname,
        workerPatronymic = this.workerPatronymic
    )

fun RestaurantReview.toApi(): RestaurantReviewEntityForApi =
    RestaurantReviewEntityForApi(
        id = this.id,
        workerId = this.workerId,
        restaurantId = this.restaurantId,
        rating = this.rating,
        text = this.text,
        workerName = this.workerName,
        workerSurname = this.workerSurname,
        workerPatronymic = this.workerPatronymic
    )