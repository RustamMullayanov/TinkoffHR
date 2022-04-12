package com.example.tinkoff_hr.data.api

import com.example.api.common.api.base.EnvelopeCall
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantEntityForApi
import com.example.tinkoff_hr.data.entities.restaurant.RestaurantReviewEntityForApi
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitServiceRestaurants {
    // Requests for Restaurants and RestaurantsReviews
    @GET("/api/restaurants")
    fun getRestaurantsList(): EnvelopeCall<List<RestaurantEntityForApi>>

    @GET("/api/restaurants/{id}")
    fun getRestaurantById(@Path("id") id: String): EnvelopeCall<RestaurantEntityForApi>

    @GET("/api/restaurants/{id}/reviews")
    fun getRestaurantsReviewsList(@Path("id") id: String): EnvelopeCall<List<RestaurantReviewEntityForApi>>

    @POST("/api/restaurants/{id}/reviews")
    fun saveRestaurantReview(
        @Path("id") id: String,
        @Body review: RestaurantReviewEntityForApi
    ): EnvelopeCall<RestaurantReviewEntityForApi>
}