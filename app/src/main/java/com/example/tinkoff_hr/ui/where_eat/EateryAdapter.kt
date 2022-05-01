package com.example.tinkoff_hr.ui.where_eat

import android.annotation.SuppressLint
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class EateryAdapter(clickListener: ClickListener) : ListDelegationAdapter<List<BaseListItem>>() {

    init {
        delegatesManager.apply {
            addDelegate(EateryDelegateProvider.provideDelegate(clickListener::onEateryClicked))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewItems(newItems: List<BaseListItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onEateryClicked(id: String)
    }
}