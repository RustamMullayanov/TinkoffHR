package com.example.tinkoff_hr.domain.factories

import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.ui.workers.WorkerItem
import com.example.tinkoff_hr.ui.where_eat.RestaurantItem
import com.example.tinkoff_hr.ui.where_eat.eatery_information.RestaurantReviewItem
import javax.inject.Inject

class DataItemFactory @Inject constructor() {

    fun createWorkerItems(workers: List<Worker>): List<WorkerItem> {
        return workers.map { worker -> worker.toListItem() }
    }

    private fun Worker.toListItem(): WorkerItem =
        WorkerItem(
            id = this.id,
            name = this.name,
            surname = this.surname,
            patronymic = this.patronymic,
            photo = this.photo,
            project = this.project,
            function = this.function,
        )

    fun createRestaurantItems(restaurants: List<Restaurant>): List<RestaurantItem> {
        return restaurants.map { restaurant -> restaurant.toListItem() }
    }

    private fun Restaurant.toListItem(): RestaurantItem =
        RestaurantItem(
            id = this.id,
            name = this.name,
            rating = this.rating,
            latitude = this.latitude,
            longitude = this.longitude
        )

    fun createRestaurantReviewItems(reviews: List<RestaurantReview>): List<RestaurantReviewItem> {
        return reviews.map { review -> review.toListItem() }
    }

    fun createRestaurantReviewItem(review: RestaurantReview): RestaurantReviewItem =
        review.toListItem()

    private fun RestaurantReview.toListItem(): RestaurantReviewItem =
        RestaurantReviewItem(
            id = id,
            workerId = workerId,
            rating = rating,
            restaurantId = restaurantId,
            text = text,
            workerName = workerName,
            workerSurname = workerSurname,
            workerPatronymic = workerPatronymic
        )

}


