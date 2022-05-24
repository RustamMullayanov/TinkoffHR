package com.example.tinkoff_hr.data.dto

import com.example.tinkoff_hr.data.entities.orders.ProductEntityForApi
import com.example.tinkoff_hr.domain.entities.orders.Product

fun ProductEntityForApi.toDomain(): Product =
    Product(
        id = this.id,
        name = this.name,
        types = listOf(this.categoryProduct)
    )