package com.example.tinkoff_hr.ui.orders

import com.example.tinkoff_hr.ui.tribute.item.BaseListItem

data class ProductItem(
    override val id: String,
    val name: String,
    val types: List<String>,
):BaseListItem
