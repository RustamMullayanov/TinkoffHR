package com.example.tinkoff_hr.presentation.orders

import com.example.tinkoff_hr.base.BasePresenter
import com.example.tinkoff_hr.domain.factories.DataItemFactory
import com.example.tinkoff_hr.domain.usecases.orders.GetProductFiltersInfoUseCase
import com.example.tinkoff_hr.domain.usecases.orders.GetProductsInfoUseCase
import com.example.tinkoff_hr.ui.orders.ProductFilterItem
import com.example.tinkoff_hr.ui.orders.ProductItem
import com.example.tinkoff_hr.views.orders.OrdersView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class OrdersPresenter @Inject constructor(
    private val getProductsInfo: GetProductsInfoUseCase,
    private val getProductFiltersInfo: GetProductFiltersInfoUseCase
) : BasePresenter<OrdersView>() {

    private var products: List<ProductItem>? = null
    private var filters: List<ProductFilterItem>? = null
    private val activeFilters: MutableList<String> = mutableListOf()

    fun getProducts() {
        getProductsInfo()
            .map { list -> DataItemFactory().createProductItems(list) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ products ->
                this.products = products
                viewState.showProductsInfo(products)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }

    fun getProductFilters() {
        getProductFiltersInfo()
            .map { list -> DataItemFactory().createProductFilterItems(list) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ filters ->
                this.filters = filters
                viewState.showProductFiltersInfo(filters)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }

    fun addFilter(filter: String) {
        activeFilters.add(filter)
    }

    fun removeFilter(filter: String) {
        activeFilters.remove(filter)
    }

    fun getProductsByFilter() {
        if (activeFilters.isEmpty()) viewState.showProductsInfo(products!!)
        else viewState.showProductsInfo(products!!.filter { product ->
            product.types.any { type ->
                activeFilters.contains(
                    type
                )
            }
        })
    }

}