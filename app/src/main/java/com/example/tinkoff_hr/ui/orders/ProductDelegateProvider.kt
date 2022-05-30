package com.example.tinkoff_hr.ui.orders

import android.content.res.ColorStateList
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ItemProductBinding
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object ProductDelegateProvider {
    fun provideDelegate(
        itemClickListener: (String) -> Unit
    ) = adapterDelegateViewBinding<ProductItem, BaseListItem, ItemProductBinding>(
        { layoutInflater, root -> ItemProductBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            with(binding) {
                productName.text = item.name
            }

            itemView.setOnClickListener {
                itemClickListener.invoke("")
            }

        }
    }
}