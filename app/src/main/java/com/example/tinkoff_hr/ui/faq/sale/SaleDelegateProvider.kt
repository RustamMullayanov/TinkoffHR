package com.example.tinkoff_hr.ui.faq.sale

import android.content.Intent
import android.view.View
import com.example.tinkoff_hr.databinding.ItemMeetUpBinding
import com.example.tinkoff_hr.databinding.ItemSaleBinding
import com.example.tinkoff_hr.ui.faq.sale.sale_partner.SalePartnerActivity
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.example.tinkoff_hr.ui.tribute.item.MeetUpItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object SaleDelegateProvider {
    fun provideDelegate(
        itemClickListener: () -> Unit
    ) = adapterDelegateViewBinding<SaleItem, BaseListItem, ItemSaleBinding>(
        { layoutInflater, root -> ItemSaleBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            with(binding) {
                nameSale.text = item.name
                informationSale.text = item.information
                logoSale.setImageResource(item.logoResource)
                cardEducation.setOnClickListener {
                    itemClickListener.invoke()
                }
            }

        }
    }
}