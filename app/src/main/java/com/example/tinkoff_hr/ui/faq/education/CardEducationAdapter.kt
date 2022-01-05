package com.example.tinkoff_hr.ui.faq.education

import android.annotation.SuppressLint
import android.app.ProgressDialog.show
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoff_hr.databinding.CardEducationBinding
import androidx.core.content.ContextCompat.startActivity

import android.content.Intent





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
            titleEducation.text = item.title
            informationEducation.text = item.information
            logoEducation.setImageResource(item.logoResource)

            holder.viewBinding.cardEducation.setOnClickListener {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse(item.url)
                it.context.startActivity(openURL)
            }
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