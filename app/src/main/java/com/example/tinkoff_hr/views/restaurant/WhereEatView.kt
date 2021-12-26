package com.example.tinkoff_hr.views.restaurant

import com.example.tinkoff_hr.base.BaseView
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface WhereEatView: BaseView {
    fun setRestaurantsInfo(restaurants: List<Restaurant>)
}