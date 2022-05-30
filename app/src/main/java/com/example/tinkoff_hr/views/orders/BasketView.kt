package com.example.tinkoff_hr.views.orders

import com.example.tinkoff_hr.base.BaseView
import com.example.tinkoff_hr.ui.orders.ProductItem
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface BasketView : BaseView {
    fun showProductsInfo(products: List<ProductItem>)
}