package com.example.tinkoff_hr.ui.where_eat

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.CardEateryBinding
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant

class EateryAdapter(private val clickListener: (String) -> Unit) :
    RecyclerView.Adapter<EateryAdapter.EateryHolder>() {

    private var eateries: List<Restaurant> = emptyList()

    class EateryHolder(val viewBinding: CardEateryBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EateryHolder {
        val binding = CardEateryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return EateryHolder(binding)
    }

    override fun onBindViewHolder(holder: EateryHolder, position: Int) {
        val item = eateries[position]
        with(holder.viewBinding) {
            rating.text = item.rating.toString()
            rating.setTextColor(setColor(item.rating, rating.context))
            name.text = item.name
        }

        holder.itemView.setOnClickListener {
            clickListener.invoke(item.id)
        }
    }

    private fun setColor(rating: Double?, context: Context): Int {
        if (rating!! >= 4.5)
            return ContextCompat.getColor(context, R.color.rating_excellent)
        if (rating >= 4)
            return ContextCompat.getColor(context, R.color.rating_very_good)
        if (rating >= 3.5)
            return ContextCompat.getColor(context, R.color.rating_good)
        return ContextCompat.getColor(context, R.color.rating_bad)
    }

    override fun getItemCount(): Int {
        return eateries.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Restaurant>) {
        eateries = list
        notifyDataSetChanged()
    }
}