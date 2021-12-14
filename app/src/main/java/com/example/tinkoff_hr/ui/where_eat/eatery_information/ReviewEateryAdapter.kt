package com.example.tinkoff_hr.ui.where_eat.eatery_information

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.CardReviewEateryBinding
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview


class ReviewEateryAdapter : RecyclerView.Adapter<ReviewEateryAdapter.ReviewEateryHolder>() {

    private var reviews: List<RestaurantReview> = emptyList()

    class ReviewEateryHolder(val viewBinding: CardReviewEateryBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewEateryHolder {
        val binding =
            CardReviewEateryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ReviewEateryHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewEateryHolder, position: Int) {
        val item = reviews[position]
        with(holder.viewBinding) {
            reviewerName.text = item.workerFullName
            reviewText.text = item.text
            reviewerPhoto.setImageResource(R.drawable.ic_account_circle_24)
        }

    }

    override fun getItemCount(): Int {
        return reviews.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<RestaurantReview>) {
        reviews = list
        notifyDataSetChanged()
    }

}
