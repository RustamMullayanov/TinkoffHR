package com.example.tinkoff_hr.ui.faq.sale

import com.example.tinkoff_hr.ui.tribute.item.BaseListItem

data class SaleItem(
    val logoResource: Int,
    val information: String,
    val name: String,
    override val id: String = "State"
) : BaseListItem