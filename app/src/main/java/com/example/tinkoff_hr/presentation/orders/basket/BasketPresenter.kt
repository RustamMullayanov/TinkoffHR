package com.example.tinkoff_hr.presentation.orders.basket

import com.example.tinkoff_hr.base.BasePresenter
import com.example.tinkoff_hr.domain.factories.DataItemFactory
import com.example.tinkoff_hr.domain.usecases.orders.GetProductsInfoUseCase
import com.example.tinkoff_hr.ui.orders.ProductItem
import com.example.tinkoff_hr.views.orders.BasketView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class BasketPresenter @Inject constructor(
) : BasePresenter<BasketView>() {

    private var products: List<ProductItem>? = null

}