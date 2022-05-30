package com.example.tinkoff_hr.ui.orders.basket

import android.annotation.SuppressLint
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class BasketAdapter(clickListener: ClickListener) : ListDelegationAdapter<List<BaseListItem>>() {

    init {
        delegatesManager.apply {
            addDelegate(BasketDelegateProvider.provideDelegate(clickListener::onProductClicked))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewItems(newItems: List<BaseListItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onProductClicked()
    }

}