package com.example.tinkoff_hr.ui.orders

import com.example.tinkoff_hr.databinding.ItemProductFilterBinding
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object ProductFilterDelegateProvider {
    fun provideDelegate(
        itemClickListener: (String) -> Unit
    ) = adapterDelegateViewBinding<ProductFilterItem, BaseListItem, ItemProductFilterBinding>(
        { layoutInflater, root -> ItemProductFilterBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            with(binding) {
                productFilterType.text = item.typeProduct
            }
        }
    }
}