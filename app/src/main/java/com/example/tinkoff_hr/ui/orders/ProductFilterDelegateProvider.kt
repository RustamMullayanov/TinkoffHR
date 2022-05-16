package com.example.tinkoff_hr.ui.orders

import android.content.res.ColorStateList
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ItemProductFilterBinding
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object ProductFilterDelegateProvider {
    fun provideDelegate(
        itemClickListener: (String, Boolean) -> Unit
    ) = adapterDelegateViewBinding<ProductFilterItem, BaseListItem, ItemProductFilterBinding>(
        { layoutInflater, root -> ItemProductFilterBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            var isSelected = false
            with(binding) {
                productFilterType.text = item.typeProduct
            }
            itemView.setOnClickListener {
                if (isSelected) {
                    binding.productFilterCard.backgroundTintList =
                        ColorStateList.valueOf(getColor(R.color.main_purple))
                    isSelected = false
                } else {
                    binding.productFilterCard.backgroundTintList =
                        ColorStateList.valueOf(getColor(R.color.pale_yellow))
                    isSelected = true
                }
                itemClickListener.invoke(item.typeProduct, isSelected)
            }
        }
    }
}