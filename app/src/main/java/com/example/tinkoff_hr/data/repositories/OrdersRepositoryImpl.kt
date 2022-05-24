package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.data.api.RetrofitServiceProducts
import com.example.tinkoff_hr.data.dto.toDomain
import com.example.tinkoff_hr.domain.entities.orders.Product
import com.example.tinkoff_hr.domain.entities.orders.ProductFilter
import com.example.tinkoff_hr.domain.repositories_interface.OrdersRepository
import io.reactivex.Single
import javax.inject.Inject

class OrdersRepositoryImpl @Inject constructor(
    private val retrofitServiceProducts: RetrofitServiceProducts
) : OrdersRepository {

    //хардкод
    private var products: List<Product> = emptyList()


    private val filters: List<ProductFilter> = listOf(
        ProductFilter("1", "Молочка"),
        ProductFilter("2", "Напиток"),
        ProductFilter("3", "Фильтр 1"),
        ProductFilter("4", "Фильтр 2"),
        ProductFilter("3", "Фильтр 3"),
        ProductFilter("4", "Фильтр 4"),
    )

    override fun getProductsInfo(): Single<List<Product>> {
        return retrofitServiceProducts.getProductsList().asSingle()
            .map { list -> list.map { it.toDomain() } }
            .doOnSuccess { list -> products = list }
    }

    override fun getProductFiltersInfo(): Single<List<ProductFilter>> {
        // val test: List<ProductFilter> = listOf(products.map { product -> product.types })
        return Single.just(filters)
    }
}