package com.example.tinkoff_hr.presentation.restaurant

import com.example.tinkoff_hr.base.BasePresenter
import com.example.tinkoff_hr.domain.usecases.restaurant.GetRestaurantInfoByIdUseCase
import com.example.tinkoff_hr.domain.usecases.restaurant.GetReviewsInfoByRestaurantIdUseCase
import com.example.tinkoff_hr.domain.usecases.restaurant.SaveRestaurantReview
import com.example.tinkoff_hr.views.restaurant.EateryInfoView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class EateryInfoPresenter @Inject constructor(
    private val getRestaurantInfoByIdUseCase: GetRestaurantInfoByIdUseCase,
    private val getReviewsInfoByRestaurantIdUseCase: GetReviewsInfoByRestaurantIdUseCase,
    private val saveRestaurantReview: SaveRestaurantReview
) : BasePresenter<EateryInfoView>() {
    fun onAppearing(id: Int){
        return getRestaurantInfoByIdUseCase(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ restaurant ->
                viewState.setRestaurantInfo(restaurant)
                setRestaurantReviewsInfo(restaurant.id)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()

    }

    private fun setRestaurantReviewsInfo(id: Int){
        return getReviewsInfoByRestaurantIdUseCase(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ reviews ->
                viewState.setRestaurantReviewsInfo(reviews)
                viewState.showSuccess("Отзывы успешно загрузились")
            }, { error ->
                viewState.showError("Отзывов нет или они не доступны")
                Timber.e(error)
            }).disposeOnFinish()
    }
}