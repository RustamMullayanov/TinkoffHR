package com.example.tinkoff_hr.ui.tribute

import android.annotation.SuppressLint
import com.example.tinkoff_hr.ui.tribute.delegate.*
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MyListAdapter(clickListener: ClickListener) : ListDelegationAdapter<List<BaseListItem>>() {

    init {
        delegatesManager.apply {
            addDelegate(TitleDelegateProvider.provideDelegate(clickListener::onTitleItemClicked))
            addDelegate(EducationDelegateProvider.provideDelegate(clickListener::onEducationItemClicked))
            addDelegate(MeetUpDelegateProvider.provideDelegate(clickListener::onMeetUpItemClicked))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewItems(newItems: List<BaseListItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    interface ClickListener {

        fun onTitleItemClicked(id: String)

        fun onEducationItemClicked(id: String)

        fun onMeetUpItemClicked(id: String)
    }

}