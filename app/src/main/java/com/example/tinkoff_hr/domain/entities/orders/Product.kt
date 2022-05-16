package com.example.tinkoff_hr.domain.entities.orders

data class Product(
    val id: String,
    val name: String,
    val types: List<String>,
)