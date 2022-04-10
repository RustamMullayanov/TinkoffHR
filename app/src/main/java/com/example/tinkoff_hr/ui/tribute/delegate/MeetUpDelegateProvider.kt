package com.example.tinkoff_hr.ui.tribute.delegate

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
            binding.cardBigTitle.text = getString(R.string.meetup)
            binding.cardBigText.text = getString(R.string.meetupBigInfo)
            binding.cardLeftText.text = getString(R.string.meetupSmallLeft)
            binding.cardRightText.text = getString(R.string.meetupSmallRight)
        }
    }
}