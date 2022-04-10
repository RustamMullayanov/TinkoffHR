package com.example.tinkoff_hr.ui.tribute.delegate

import android.view.View
import com.example.tinkoff_hr.R
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
                cardBigTitle.text = item.largeMeetUp.title
                cardBigText.text = item.largeMeetUp.information
                cardLeftText.text = item.smallMeetUpList[0].question
                cardRightText.text = item.smallMeetUpList[1].question

                cardLinLeft.setOnClickListener {
                    itemClickListener.invoke(item.smallMeetUpList[0].information)
                }

                cardLinRight.setOnClickListener {
                    itemClickListener.invoke(item.smallMeetUpList[1].information)
                }
            }

        }
    }
}