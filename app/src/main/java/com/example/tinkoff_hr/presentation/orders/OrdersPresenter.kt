package com.example.tinkoff_hr.presentation.orders

import com.example.tinkoff_hr.base.BasePresenter
import com.example.tinkoff_hr.domain.factories.DataItemFactory
import com.example.tinkoff_hr.domain.usecases.orders.GetProductsInfoAndFiltersUseCase
import com.example.tinkoff_hr.ui.orders.ProductItem
import com.example.tinkoff_hr.views.orders.OrdersView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class OrdersPresenter @Inject constructor(
    private val getProductsInfoAndFilters: GetProductsInfoAndFiltersUseCase
) : BasePresenter<OrdersView>() {

    private var products: List<ProductItem> = emptyList()
    private val activeFilters: MutableList<String> = mutableListOf()

    override fun onFirstViewAttach() {
        getProductsAndFilters()
    }

    private fun getProductsAndFilters() {
        getProductsInfoAndFilters()
            .map { (products, filters) ->
                Pair(
                    DataItemFactory().createProductItems(products),
                    DataItemFactory().createProductFilterItems(filters)
                )
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ (productItems, filterItems) ->
                products = productItems
                viewState.showProductsInfo(productItems)
                viewState.showProductFiltersInfo(filterItems)
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
        if (activeFilters.isEmpty()) viewState.showProductsInfo(products)
        else viewState.showProductsInfo(products.filter { product ->
            product.types.any { type ->
                activeFilters.contains(
                    type
                )
            }
        })
    }

}