package com.example.tinkoff_hr.ui.workers

import android.annotation.SuppressLint
import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.entities.worker.WorkerItem
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class WorkerAdapter(clickListener: ClickListener) : ListDelegationAdapter<List<BaseListItem>>() {

    init {
        delegatesManager.apply {
            addDelegate(WorkerDelegateProvider.provideDelegate(clickListener::onWorkerClicked))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewItems(newItems: List<BaseListItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onWorkerClicked(workerId: String)
    }

}