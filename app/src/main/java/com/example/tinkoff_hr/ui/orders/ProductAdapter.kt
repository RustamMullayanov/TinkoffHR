package com.example.tinkoff_hr.ui.orders

import android.annotation.SuppressLint
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ProductAdapter(clickListener: ClickListener) : ListDelegationAdapter<List<BaseListItem>>() {

    init {
        delegatesManager.apply {
            addDelegate(ProductDelegateProvider.provideDelegate(clickListener::onProductClicked))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewItems(newItems: List<BaseListItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onProductClicked(productId: String)
    }

}