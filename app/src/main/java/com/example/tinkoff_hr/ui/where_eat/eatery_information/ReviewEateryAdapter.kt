package com.example.tinkoff_hr.ui.where_eat.eatery_information

import android.annotation.SuppressLint
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter


class ReviewEateryAdapter : ListDelegationAdapter<List<BaseListItem>>(){

    init {
        delegatesManager.apply {
            addDelegate(ReviewEateryDelegateProvider.provideDelegate())
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewItems(newItems: List<BaseListItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyItemChanged")
    fun setItem(item: BaseListItem) {
        items = items?.plus(item)
        notifyItemChanged(itemCount)
    }
}
