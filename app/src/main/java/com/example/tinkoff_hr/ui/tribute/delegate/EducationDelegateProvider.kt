package com.example.tinkoff_hr.ui.tribute.delegate

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ItemEducationBinding
import com.example.tinkoff_hr.ui.tribute.data.Education
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.example.tinkoff_hr.ui.tribute.item.EducationItem
import com.google.android.material.card.MaterialCardView
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object EducationDelegateProvider {

    fun provideDelegate(
        itemClickListener: (id: String) -> Unit
    ) = adapterDelegateViewBinding<EducationItem, BaseListItem, ItemEducationBinding>(
        { layoutInflater, root -> ItemEducationBinding.inflate(layoutInflater, root, false) }
    ) {



        fun setData(title: TextView, image: ImageView, edu: Education, information: TextView?) {
            title.text = edu.name
            image.setImageResource(edu.scrImg)
            information?.text = edu.information
        }

        bind {
            with(binding) {
                if (item.list.size >= 1) {
                    setData(titleEducationL, logoEducationL, item.list[0], informationEducation)
                    cardConstL.setOnClickListener {
                        itemClickListener.invoke(item.list[0].url)
                    }
                } else cardEducationL.visibility = View.GONE

                if (item.list.size >= 2) {
                    setData(titleEducationS1, logoEducationS1, item.list[1], null)
                    cardLinS1.setOnClickListener {
                        itemClickListener.invoke(item.list[1].url)
                    }
                } else cardEducationS1.visibility = View.GONE

                if (item.list.size >= 3) {
                    setData(titleEducationS2, logoEducationS2, item.list[2], null)
                    cardLinS2.setOnClickListener {
                        itemClickListener.invoke(item.list[2].url)
                    }
                } else cardEducationS2.visibility = View.GONE

                if (item.list.size >= 4) {
                    setData(titleEducationS3, logoEducationS3, item.list[3], null)
                    cardLinS3.setOnClickListener {
                        itemClickListener.invoke(item.list[3].url)
                    }
                } else cardEducationS3.visibility = View.GONE
            }

        }
    }


}