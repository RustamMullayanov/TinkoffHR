package com.example.tinkoff_hr.presentation.restaurant

import com.example.tinkoff_hr.domain.usecases.restaurant.GetRestaurantsInfoUseCase
import com.example.tinkoff_hr.views.restaurant.WhereEatView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class WhereEatPresenter @Inject constructor(
    private val getRestaurantsInfoUseCase: GetRestaurantsInfoUseCase
) : MvpPresenter<WhereEatView>() {
    override fun onFirstViewAttach() {
        setRestaurants()
    }

    private fun setRestaurants() {
        val restaurants = getRestaurantsInfoUseCase()
        viewState.setRestaurantsInfo(restaurants)
        viewState.showSuccess("Данные успешно загрузились")
    }
}