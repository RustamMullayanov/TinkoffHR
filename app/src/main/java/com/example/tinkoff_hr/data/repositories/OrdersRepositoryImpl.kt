package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.data.api.RetrofitServiceProducts
import com.example.tinkoff_hr.data.dto.toDomain
import com.example.tinkoff_hr.domain.entities.orders.Product
import com.example.tinkoff_hr.domain.repositories_interface.OrdersRepository
import io.reactivex.Single
import javax.inject.Inject

class OrdersRepositoryImpl @Inject constructor(
    private val retrofitServiceProducts: RetrofitServiceProducts
) : OrdersRepository {

    override fun getProductsInfo(): Single<List<Product>> {
        return retrofitServiceProducts.getProductsList().asSingle()
            .map { list -> list.map { it.toDomain() } }
    }
}