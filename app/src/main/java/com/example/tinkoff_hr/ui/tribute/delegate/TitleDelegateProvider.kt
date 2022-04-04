package com.example.tinkoff_hr.ui.tribute.delegate

import com.example.tinkoff_hr.databinding.ItemTitleBinding
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.example.tinkoff_hr.ui.tribute.item.TitleItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object TitleDelegateProvider {

    fun provideDelegate(
        itemClickListener: (String) -> Unit
    ) = adapterDelegateViewBinding<TitleItem, BaseListItem, ItemTitleBinding>(
        { layoutInflater, root -> ItemTitleBinding.inflate(layoutInflater, root, false) }
    ) {

        binding.title.setOnClickListener {
            // handle click
            itemClickListener.invoke(item.id)
        }

        bind {
            binding.title.text = item.id
        }
    }
}