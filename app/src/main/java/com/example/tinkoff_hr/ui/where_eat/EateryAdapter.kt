package com.example.tinkoff_hr.ui.where_eat

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.CardEateryBinding

class EateryAdapter : RecyclerView.Adapter<EateryAdapter.EateryHolder>() {

        private var states: List<Eatery> = emptyList()

        class EateryHolder(val viewBinding: CardEateryBinding) : RecyclerView.ViewHolder(viewBinding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EateryHolder {
            val binding = CardEateryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return EateryHolder(binding)
        }

        override fun onBindViewHolder(holder: EateryHolder, position: Int) {
            with(holder.viewBinding) {

                val item = states[position]
                rating.text = item.rating.toString()
                name.text = item.name
            }
        }

        override fun getItemCount(): Int {
            return states.size
        }

        @SuppressLint("NotifyDataSetChanged")
        fun addList(list: List<Eatery>) {
            states = list
            notifyDataSetChanged()
        }
}