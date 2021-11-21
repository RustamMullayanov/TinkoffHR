package com.example.tinkoff_hr.ui.faq.MeetUp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoff_hr.databinding.CardEducationBinding


class CardEducationAdapter : RecyclerView.Adapter<CardEducationAdapter.CardEducationHolder>() {
    private var cardList: List<CardEducation> = emptyList()

    class CardEducationHolder(val viewBinding: CardEducationBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardEducationHolder {
        val binding =
            CardEducationBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CardEducationHolder(binding)
    }

    override fun onBindViewHolder(holder: CardEducationHolder, position: Int) {
        with(holder.viewBinding) {
            val item = cardList[position]
            titleEducation.setText(item.title)
            informationEducation.text = item.information
            logoEducation.setImageResource(item.logoResource)
        }
    }


    override fun getItemCount(): Int {
        return cardList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<CardEducation>) {
        cardList = list
        notifyDataSetChanged()
    }
}