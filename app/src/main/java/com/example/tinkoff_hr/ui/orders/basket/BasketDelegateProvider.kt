package com.example.tinkoff_hr.ui.orders.basket

import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ItemBasketProductBinding
import com.example.tinkoff_hr.ui.orders.ProductItem
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object BasketDelegateProvider {
    fun provideDelegate(
        itemClickListener: (ProductItem) -> Unit
    ) = adapterDelegateViewBinding<ProductItem, BaseListItem, ItemBasketProductBinding>(
        { layoutInflater, root -> ItemBasketProductBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            with(binding) {
                name.text = item.name
                information.text = "Очень жирное, 1 л."
                close.setOnClickListener {
                    itemClickListener.invoke(item)
                }
            }

        }
    }
}