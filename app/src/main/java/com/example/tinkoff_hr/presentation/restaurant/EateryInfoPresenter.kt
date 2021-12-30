package com.example.tinkoff_hr.presentation.restaurant

import com.example.tinkoff_hr.domain.usecases.restaurant.GetRestaurantInfoByIdUseCase
import com.example.tinkoff_hr.domain.usecases.restaurant.GetReviewsInfoByRestaurantIdUseCase
import com.example.tinkoff_hr.domain.usecases.restaurant.SaveRestaurantReviewUseCase
import com.example.tinkoff_hr.ui.where_eat.eatery_information.EateryContentState
import com.example.tinkoff_hr.views.restaurant.EateryInfoView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class EateryInfoPresenter @Inject constructor(
    private val getRestaurantInfoByIdUseCase: GetRestaurantInfoByIdUseCase,
    private val getReviewsInfoByRestaurantIdUseCase: GetReviewsInfoByRestaurantIdUseCase,
    private val saveRestaurantReviewUseCase: SaveRestaurantReviewUseCase
) : MvpPresenter<EateryInfoView>() {
    fun onAppearing(id: Int){
        val restaurant = getRestaurantInfoByIdUseCase(id)
        viewState.setRestaurantInfo(restaurant)
        setRestaurantReviewsInfo(id)
    }

    private fun setRestaurantReviewsInfo(id: Int) {
        val reviews = getReviewsInfoByRestaurantIdUseCase(id)
        if (reviews.isNotEmpty()) {
            viewState.setContentState(EateryContentState.CONTENT)
            viewState.setRestaurantReviewsInfo(reviews)
        } else {
            viewState.setContentState(EateryContentState.NO_CONTENT)
        }
    }
}