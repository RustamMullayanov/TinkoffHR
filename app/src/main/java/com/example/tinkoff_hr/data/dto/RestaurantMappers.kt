package com.example.tinkoff_hr.data.dto

import com.example.tinkoff_hr.data.entities.restaurant.RestaurantEntityForApi
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantEntityForDB
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant

fun Restaurant.toDb(): RestaurantEntityForDB =
    RestaurantEntityForDB(
        id = this.id,
        name = this.name,
        rating = this.rating,
        isHasLunch = this.isHasLunch,
        averageCost = this.averageCost,
        latitude = this.latitude,
        longitude = this.longitude
    )

fun RestaurantEntityForDB.toDomain(): Restaurant =
    Restaurant(
        id = this.id,
        name = this.name,
        rating = this.rating,
        isHasLunch = this.isHasLunch,
        averageCost = this.averageCost,
        latitude = this.latitude,
        longitude = this.longitude
    )

fun RestaurantEntityForApi.toDomain(): Restaurant =
    Restaurant(
        id = this.id,
        name = this.name,
        rating = this.rating,
        isHasLunch = this.isHasLunch,
        averageCost = this.averageCost,
        latitude = this.latitude,
        longitude = this.longitude
    )