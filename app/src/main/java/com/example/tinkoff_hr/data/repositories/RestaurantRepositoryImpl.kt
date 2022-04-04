package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.data.api.RetrofitServiceRestaurants
import com.example.tinkoff_hr.data.api.RetrofitServiceWorkers
import com.example.tinkoff_hr.data.dto.toDomain
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import com.example.tinkoff_hr.domain.repositories_interface.RestaurantRepository
import io.reactivex.Single
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitServiceRestaurants
) : RestaurantRepository {
    private val restaurants: List<Restaurant> = listOf(
        Restaurant(
            1, "Своя компания", 4.5, true, 500.0,
            56.83369492735619, 60.60067545372085
        ),
        Restaurant(
            2, "А ты где?", 4.1, false, 365.0,
            56.84363650463943, 60.64473482972403
        ),
        Restaurant(
            3, "Вилка Ложка", 3.2, true, 255.0,
            56.83368644477701, 60.59677928362856
        ),
        Restaurant(
            4, "Поль Бейкери", 3.9, true, 428.5,
            56.843442568345885, 60.64431272082221
        ),
        Restaurant(
            5, "Бургер Кинг", 3.5, false, 200.0,
            56.83369994292241, 60.60072929049454
        )
    )

    private val reviews: List<RestaurantReview> = listOf(
        RestaurantReview(
            1, "test1@tin.koff", "Муллаянов Рустам Радикович",
            1, "все отлично", "вкусно", ""
        ),
        RestaurantReview(
            2, "test2@tin.koff", "Крыш Андрей Константинович",
            1, "пойдет", "чисто", "долго ждать заказ"
        ),
        RestaurantReview(
            3, "test3@tin3.koff", "Петров Петр Петрович",
            1, "наелся, сплю", "отличный кофе", ""
        ),
        RestaurantReview(
            4, "test1@tin.koff", "Муллаянов Рустам Радикович",
            3, "сыр не тянется, не одобряю", "дешево", ""
        ),
        RestaurantReview(
            5, "test5@tin.koff", "Васильев Василий Васильевич",
            3, "если неделю не кушал, то пойдет", "чисто", ""
        ),
    )

    override fun getRestaurantInfoById(id: Int): Single<Restaurant> {
        return retrofitService.getRestaurantById(id.toString()).asSingle()
            .map { restaurant -> restaurant.toDomain() }
    }

    override fun getRestaurantsInfo(): Single<List<Restaurant>> {
        return retrofitService.getRestaurantsList().asSingle()
            .map { list -> list.map { it.toDomain() } }
    }

    override fun getReviewsInfoByRestaurantId(id: Int): Single<List<RestaurantReview>> {
        return retrofitService.getRestaurantsReviewsList(id.toString()).asSingle()
            .map { list -> list.map { it.toDomain() } }
    }

    override fun saveRestaurantReview(review: RestaurantReview): Boolean {
        TODO("Not yet implemented")
    }
}