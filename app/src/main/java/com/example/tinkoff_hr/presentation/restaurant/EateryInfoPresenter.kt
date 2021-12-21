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
        val restaurant = getRestaurantInfoByIdUseCase(id)
        viewState.setRestaurantInfo(restaurant)
        setRestaurantReviewsInfo(id)
    }

    private fun setRestaurantReviewsInfo(id: Int){
        val reviews = getReviewsInfoByRestaurantIdUseCase(id)
        if(reviews.isEmpty()){
            viewState.showError("Отзывов нет")
            return
        }
        viewState.setRestaurantReviewsInfo(reviews)
        viewState.showSuccess("Отзывы успешно загрузились")
    }
}