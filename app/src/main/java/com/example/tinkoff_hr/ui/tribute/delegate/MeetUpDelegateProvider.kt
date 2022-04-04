package com.example.tinkoff_hr.ui.tribute.delegate

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

        binding.cardBigTitle.text = "Meetup’s"
        binding.cardBigText.text = "В Екатеринбурге мы организуем митапы по направлениям: Angular, Scala, Android.\n" +
                "Спикеры - сотрудники ТЦРа и внешние докладчики. Если у тебя есть тема для доклада, то ты всегда можешь об этом сказать Елене Калетиной или Саше."
        binding.cardLeftText.text = "Хочется выступить в роли спикера?"
        binding.cardRightText.text = "Или быть слушателем на встрече?"


        bind {

        }
    }
}