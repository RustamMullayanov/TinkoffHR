package com.example.tinkoff_hr.views

import com.example.tinkoff_hr.domain.entities.Worker
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface ProfileView: MvpView {
    fun showWorkerInfo(worker: Worker)
    fun showError(message:String)
    fun showSuccess(message: String)
}