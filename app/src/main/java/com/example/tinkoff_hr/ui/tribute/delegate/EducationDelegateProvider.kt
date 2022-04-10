package com.example.tinkoff_hr.ui.tribute.delegate

import android.view.View
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ItemEducationBinding
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.example.tinkoff_hr.ui.tribute.item.EducationItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object EducationDelegateProvider {

    fun provideDelegate(
        itemClickListener: (id: String) -> Unit
    ) = adapterDelegateViewBinding<EducationItem, BaseListItem, ItemEducationBinding>(
        { layoutInflater, root -> ItemEducationBinding.inflate(layoutInflater, root, false) }
    ) {

        bind {
            binding.logoEducationL.setImageResource(R.drawable.scala)
            binding.titleEducationL.text = getString(R.string.scala)
            binding.titleEducationS1.text = getString(R.string.frontend)
            binding.titleEducationS2.text = getString(R.string.ios)
            binding.titleEducationS3.text = getString(R.string.ios)
            binding.informationEducation.text = getString(R.string.pastaEducation)
            binding.logoEducationS1.setImageResource(R.drawable.frontend)
            binding.logoEducationS2.setImageResource(R.drawable.ios)
            binding.logoEducationS3.setImageResource(R.drawable.ios)
        }
    }
}