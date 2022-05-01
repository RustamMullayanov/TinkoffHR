package com.example.tinkoff_hr.views

import com.example.tinkoff_hr.base.BaseView
import com.example.tinkoff_hr.domain.entities.worker.WorkerItem
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface WorkersView: BaseView {
    fun showWorkersInfo(workers: List<WorkerItem>)
}