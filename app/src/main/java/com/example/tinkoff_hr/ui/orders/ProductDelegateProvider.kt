package com.example.tinkoff_hr.ui.orders

import android.content.res.ColorStateList
import android.view.View
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
                btnOrder.setOnClickListener {
                    itemClickListener.invoke("")
                    btnOrder.isEnabled = false
                    btnOrder.setTextColor(getColor(R.color.back_grey))
                }
            }
        }
    }
}