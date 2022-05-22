package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.domain.entities.orders.Product
import com.example.tinkoff_hr.domain.entities.orders.ProductFilter
import com.example.tinkoff_hr.domain.repositories_interface.OrdersRepository
import io.reactivex.Single
import javax.inject.Inject

class OrdersRepositoryImpl @Inject constructor() : OrdersRepository {

    //хардкод
    private val products: List<Product> = listOf(
        Product("1", "Пепси", listOf("Напиток")),
        Product("2", "Творог", listOf("Молочка")),
        Product("1", "Пепси", listOf("Напиток")),
        Product("2", "Творог", listOf("Молочка")),
        Product("1", "Пепси", listOf("Напиток")),
        Product("2", "Творог", listOf("Молочка")),
        Product("1", "Пепси", listOf("Напиток")),
        Product("2", "Творог", listOf("Молочка")),
    )


    private val filters: List<ProductFilter> = listOf(
        ProductFilter("1", "Молочка"),
        ProductFilter("2", "Напиток"),
        ProductFilter("3", "Фильтр 1"),
        ProductFilter("4", "Фильтр 2"),
        ProductFilter("3", "Фильтр 3"),
        ProductFilter("4", "Фильтр 4"),
    )

    override fun getProductsInfo(): Single<List<Product>> {

        return Single.just(products)
    }

    override fun getProductFiltersInfo(): Single<List<ProductFilter>> {
        return Single.just(filters)
    }
}