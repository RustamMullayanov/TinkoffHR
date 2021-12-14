package com.example.tinkoff_hr.presentation.restaurant

import com.example.tinkoff_hr.domain.usecases.restaurant.GetRestaurantInfoByIdUseCase
import com.example.tinkoff_hr.domain.usecases.restaurant.GetRestaurantsInfoUseCase
import com.example.tinkoff_hr.domain.usecases.restaurant.GetReviewsInfoByRestaurantIdUseCase
import com.example.tinkoff_hr.domain.usecases.restaurant.SaveRestaurantReview
import com.example.tinkoff_hr.views.restaurant.EateryInfoView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class EateryInfoPresenter @Inject constructor(
    private val getRestaurantInfoByIdUseCase: GetRestaurantInfoByIdUseCase,
    private val getReviewsInfoByRestaurantIdUseCase: GetReviewsInfoByRestaurantIdUseCase,
    private val saveRestaurantReview: SaveRestaurantReview
) : MvpPresenter<EateryInfoView>() {
    fun onAppearing(id: Int){
        val restaurant = getRestaurantInfoByIdUseCase.invoke(id)
        viewState.setRestaurantInfo(restaurant)
    }

    fun setRestaurantReviewsInfo(id: Int){
        val reviews = getReviewsInfoByRestaurantIdUseCase(id)
        viewState.setRestaurantReviewsInfo(reviews)
        viewState.showSuccess("Отзывы успешно загрузились")
    }
}