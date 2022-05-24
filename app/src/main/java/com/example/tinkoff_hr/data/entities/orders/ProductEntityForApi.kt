package com.example.tinkoff_hr.data.entities.orders

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ProductEntityForApi(

    @SerialName(value = "id")
    val id: String,

    @SerialName(value = "product_name")
    val name: String,

    @SerialName(value = "category_name")
    val categoryProduct: String
)