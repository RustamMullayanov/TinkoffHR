package com.example.tinkoff_hr.domain.usecases.orders

import com.example.tinkoff_hr.domain.entities.orders.Product
import com.example.tinkoff_hr.domain.repositories_interface.OrdersRepository
import io.reactivex.Single
import javax.inject.Inject

class GetProductsInfoUseCase @Inject constructor(private val ordersRepository: OrdersRepository) {
    operator fun invoke(): Single<List<Product>> {
        return ordersRepository.getProductsInfo()
    }
}