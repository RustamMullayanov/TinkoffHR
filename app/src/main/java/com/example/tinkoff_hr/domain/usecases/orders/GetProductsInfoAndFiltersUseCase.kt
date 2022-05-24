package com.example.tinkoff_hr.domain.usecases.orders

import com.example.tinkoff_hr.domain.entities.orders.Product
import com.example.tinkoff_hr.domain.entities.orders.ProductFilter
import com.example.tinkoff_hr.domain.repositories_interface.OrdersRepository
import io.reactivex.Single
import javax.inject.Inject

class GetProductsInfoAndFiltersUseCase @Inject constructor(private val ordersRepository: OrdersRepository) {

    operator fun invoke(): Single<Pair<List<Product>, List<ProductFilter>>> {
        return ordersRepository.getProductsInfo()
            .map { products ->
                val filters = getUniqueFilters(products)
                Pair(products, filters)
            }
    }

    private fun getUniqueFilters(products: List<Product>): List<ProductFilter> {
        return products.flatMap { product -> product.types }
            .toSet()
            .map { type -> ProductFilter("", type) }
            .toList()
    }
}