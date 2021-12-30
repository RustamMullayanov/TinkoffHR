package com.example.tinkoff_hr.views.restaurant

import com.example.tinkoff_hr.base.BaseView
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import com.example.tinkoff_hr.ui.where_eat.eatery_information.EateryContentState
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface EateryInfoView: BaseView {

    fun setRestaurantInfo(restaurant: Restaurant)

    fun setRestaurantReviewsInfo(reviews: List<RestaurantReview>)

    fun setContentState(state: EateryContentState)
}