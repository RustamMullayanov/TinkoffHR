package com.example.tinkoff_hr.ui.tribute.delegate

import android.view.View
import com.example.tinkoff_hr.databinding.ItemMeetUpBinding
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.example.tinkoff_hr.ui.tribute.item.MeetUpItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MeetUpDelegateProvider {
    fun provideDelegate(
        itemClickListener: (id: String) -> Unit
    ) = adapterDelegateViewBinding<MeetUpItem, BaseListItem, ItemMeetUpBinding>(
        { layoutInflater, root -> ItemMeetUpBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            with(binding) {

                if (item.largeMeetUp != null) {
                    cardLarge.visibility = View.VISIBLE
                    cardBigTitle.text = item.largeMeetUp?.title
                    cardBigText.text = item.largeMeetUp?.information
                } else cardLarge.visibility = View.GONE

                if (item.smallMeetUpList.size >= 1) {
                    cardRight.visibility = View.VISIBLE
                    cardLeftText.text = item.smallMeetUpList[0].question
                    cardLinLeft.setOnClickListener {
                        itemClickListener.invoke(item.smallMeetUpList[0].information)
                    }
                } else cardLeft.visibility = View.GONE

                if (item.smallMeetUpList.size >= 2) {
                    cardRight.visibility = View.VISIBLE
                    cardRightText.text = item.smallMeetUpList[1].question
                    cardLinRight.setOnClickListener {
                        itemClickListener.invoke(item.smallMeetUpList[1].information)
                    }
                } else cardRight.visibility = View.GONE
            }

        }
    }
}