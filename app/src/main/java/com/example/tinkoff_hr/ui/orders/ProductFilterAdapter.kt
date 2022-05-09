package com.example.tinkoff_hr.ui.orders

import android.annotation.SuppressLint
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ProductFilterAdapter(clickListener: ClickListener) :
    ListDelegationAdapter<List<BaseListItem>>() {

    init {
        delegatesManager.apply {
            addDelegate(ProductFilterDelegateProvider.provideDelegate(clickListener::onProductFilterClicked))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewItems(newItems: List<BaseListItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onProductFilterClicked(productType: String)
    }

}