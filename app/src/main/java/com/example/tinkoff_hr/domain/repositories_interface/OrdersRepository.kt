package com.example.tinkoff_hr.domain.repositories_interface

import com.example.tinkoff_hr.domain.entities.orders.Product
import com.example.tinkoff_hr.domain.entities.orders.ProductFilter
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import io.reactivex.Single

interface OrdersRepository {

    fun getProductsInfo(): List<Product>

    fun getProductFiltersInfo(): List<ProductFilter>
}