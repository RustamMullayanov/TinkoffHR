package com.example.tinkoff_hr.presentation.restaurant

import com.example.tinkoff_hr.base.BasePresenter
import com.example.tinkoff_hr.domain.usecases.restaurant.GetRestaurantsInfoUseCase
import com.example.tinkoff_hr.views.restaurant.WhereEatView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class WhereEatPresenter @Inject constructor(
    private val getRestaurantsInfoUseCase: GetRestaurantsInfoUseCase
) : BasePresenter<WhereEatView>() {
    override fun onFirstViewAttach() {
        setRestaurants()
    }

    private fun setRestaurants() {
        return getRestaurantsInfoUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ restaurants ->
                viewState.setRestaurantsInfo(restaurants)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }
}