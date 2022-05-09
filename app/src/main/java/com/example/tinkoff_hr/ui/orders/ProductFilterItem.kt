package com.example.tinkoff_hr.ui.orders

import com.example.tinkoff_hr.ui.tribute.item.BaseListItem

data class ProductFilterItem(
    override val id: String,
    val typeProduct: String,
):BaseListItem
