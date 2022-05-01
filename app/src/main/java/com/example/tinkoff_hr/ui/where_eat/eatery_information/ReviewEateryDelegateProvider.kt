package com.example.tinkoff_hr.ui.where_eat.eatery_information

import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ItemReviewEateryBinding
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object ReviewEateryDelegateProvider {
    fun provideDelegate(
    ) = adapterDelegateViewBinding<RestaurantReview, BaseListItem, ItemReviewEateryBinding>(
        { layoutInflater, root -> ItemReviewEateryBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            with(binding) {
                reviewerName.text = "${item.workerSurname} ${item.workerName} ${item.workerPatronymic ?: ""}"
                reviewText.text = item.text
                reviewerPhoto.setImageResource(R.drawable.ic_account_circle_24)
            }
        }
    }
}