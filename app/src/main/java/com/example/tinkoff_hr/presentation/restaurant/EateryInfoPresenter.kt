package com.example.tinkoff_hr.presentation.restaurant

import com.example.tinkoff_hr.base.BasePresenter
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import com.example.tinkoff_hr.domain.factories.DataItemFactory
import com.example.tinkoff_hr.domain.usecases.restaurant.GetRestaurantInfoByIdUseCase
import com.example.tinkoff_hr.domain.usecases.restaurant.GetReviewsInfoByRestaurantIdUseCase
import com.example.tinkoff_hr.domain.usecases.restaurant.SaveRestaurantReviewUseCase
import com.example.tinkoff_hr.ui.where_eat.eatery_information.RestaurantReviewItem
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
    private val saveRestaurantReviewUseCase: SaveRestaurantReviewUseCase
) : BasePresenter<EateryInfoView>() {

    val factory = DataItemFactory()

    fun onAppearing(id: String) {
        return getRestaurantInfoByIdUseCase(id)
            .doOnSuccess { restaurant -> setRestaurantReviewsInfo(restaurant.id) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ restaurant ->
                viewState.setRestaurantInfo(restaurant)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }

    private fun setRestaurantReviewsInfo(id: String) {
        return getReviewsInfoByRestaurantIdUseCase(id)
            .map { reviews -> factory.createRestaurantReviewItems(reviews) }
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

    fun saveRestaurantReview(restaurantId: String, review: RestaurantReview) {
        return saveRestaurantReviewUseCase(restaurantId, review)
            .map { r -> factory.createRestaurantReviewItem(r) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ newReview ->
                viewState.setRestaurantReviewInfo(newReview)
                viewState.showSuccess("Отзыв успешно сохранен")
            }, { error ->
                viewState.showError("Отзыв не сохранен, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }
}