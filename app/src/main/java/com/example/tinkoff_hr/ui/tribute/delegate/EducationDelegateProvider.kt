package com.example.tinkoff_hr.ui.tribute.delegate

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.tinkoff_hr.databinding.ItemEducationBinding
import com.example.tinkoff_hr.ui.tribute.data.Education
import com.example.tinkoff_hr.ui.tribute.data.EducationLarge
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.example.tinkoff_hr.ui.tribute.item.EducationItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object EducationDelegateProvider {

    fun provideDelegate(
        itemClickListener: (id: String) -> Unit
    ) = adapterDelegateViewBinding<EducationItem, BaseListItem, ItemEducationBinding>(
        { layoutInflater, root -> ItemEducationBinding.inflate(layoutInflater, root, false) }
    ) {
        fun setData(title: TextView, image: ImageView, edu: Education) {
            title.text = edu.name
            image.setImageResource(edu.scrImg)
        }

        fun setLargeData(title: TextView, image: ImageView, edu: EducationLarge, info: TextView) {
            title.text = edu.name
            image.setImageResource(edu.scrImg)
            info.text = edu.information
        }

        bind {
            with(binding) {
                //Large Education
                setLargeData(titleEducationL, logoEducationL, item.largeEdu, informationEducation)
                cardConstL.setOnClickListener {
                    itemClickListener.invoke(item.largeEdu.url)
                }

                if (item.smallEduList.size >= 1) {
                    cardEducationS1.visibility = View.VISIBLE
                    setData(titleEducationS1, logoEducationS1, item.smallEduList[0])
                    cardLinS1.setOnClickListener {
                        itemClickListener.invoke(item.smallEduList[0].url)
                    }
                } else cardEducationS1.visibility = View.GONE

                if (item.smallEduList.size >= 2) {
                    cardEducationS2.visibility = View.VISIBLE
                    setData(titleEducationS2, logoEducationS2, item.smallEduList[1])
                    cardLinS2.setOnClickListener {
                        itemClickListener.invoke(item.smallEduList[1].url)
                    }
                } else cardEducationS2.visibility = View.GONE

                if (item.smallEduList.size >= 3) {
                    cardEducationS3.visibility = View.VISIBLE
                    setData(titleEducationS3, logoEducationS3, item.smallEduList[2])
                    cardLinS3.setOnClickListener {
                        itemClickListener.invoke(item.smallEduList[2].url)
                    }
                } else cardEducationS3.visibility = View.GONE
            }

        }
    }
}