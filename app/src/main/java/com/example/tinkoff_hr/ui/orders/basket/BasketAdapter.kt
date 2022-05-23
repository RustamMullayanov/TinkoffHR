package com.example.tinkoff_hr.ui.orders.basket

import android.annotation.SuppressLint
import com.example.tinkoff_hr.ui.orders.ProductItem
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class BasketAdapter(clickListener: ClickListener) : ListDelegationAdapter<List<BaseListItem>>() {

    init {
        delegatesManager.apply {
            addDelegate(BasketDelegateProvider.provideDelegate(clickListener::onProductClicked))
        }
    }

    fun noItems(): Boolean = items?.isEmpty() ?: true

    @SuppressLint("NotifyDataSetChanged")
    fun setNewItems(newItems: List<BaseListItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteItem(product: ProductItem) {
        items = items?.minus(product)
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onProductClicked(product: ProductItem)
    }

}