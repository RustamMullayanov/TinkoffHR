package com.example.tinkoff_hr.views.authentication

import com.example.tinkoff_hr.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface CodeView: BaseView {
    fun startCodeTimer()
    fun openContentActivity()
    fun openProfileSettingsActivity()
}