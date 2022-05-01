package com.example.tinkoff_hr.ui.where_eat

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ItemEateryBinding
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object EateryDelegateProvider {
    fun provideDelegate(
        itemClickListener: (id: String) -> Unit
    ) = adapterDelegateViewBinding<Restaurant, BaseListItem, ItemEateryBinding>(
        { layoutInflater, root -> ItemEateryBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            with(binding) {
                rating.text = item.rating.toString()
                rating.setTextColor(setColor(item.rating, rating.context))
                name.text = item.name

                itemView.setOnClickListener {
                    itemClickListener.invoke(item.id)
                }
            }

        }
    }

    private fun setColor(rating: Double, context: Context): Int {
        if (rating >= 4.5)
            return ContextCompat.getColor(context, R.color.rating_excellent)
        if (rating >= 4)
            return ContextCompat.getColor(context, R.color.rating_very_good)
        if (rating >= 3.5)
            return ContextCompat.getColor(context, R.color.rating_good)
        return ContextCompat.getColor(context, R.color.rating_bad)
    }
}