package com.example.tinkoff_hr.ui.faq.sale

import android.annotation.SuppressLint
import com.example.tinkoff_hr.ui.tribute.delegate.TitleDelegateProvider
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class SaleAdapter(clickListener: SaleAdapter.ClickListener) : ListDelegationAdapter<List<BaseListItem>>() {

    init {
        delegatesManager.apply {
            addDelegate(TitleDelegateProvider.provideDelegate(clickListener::onTitleItemClicked))
            addDelegate(SaleDelegateProvider.provideDelegate(clickListener::onSaleItemClicked))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewItems(newItems: List<BaseListItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onSaleItemClicked()
        fun onTitleItemClicked(id:String)
    }
}