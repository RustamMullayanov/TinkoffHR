package com.example.tinkoff_hr.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface BaseView : MvpView {
    fun showError(message:String)
    fun showSuccess(message: String)
}