package com.example.tinkoff_hr.ui.workers

import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ItemWorkerBinding
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object WorkerDelegateProvider {
    fun provideDelegate(
        itemClickListener: (String) -> Unit
    ) = adapterDelegateViewBinding<WorkerItem, BaseListItem, ItemWorkerBinding>(
        { layoutInflater, root -> ItemWorkerBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            with(binding) {
                nameFieldWorker.text = "${item.surname} ${item.name} ${item.patronymic ?: ""}"
                functionFieldWorker.text = item.function
                projectFieldWorker.text = item.project
                photoWorker.setImageResource(R.drawable.ic_account_circle_24)
            }
            itemView.setOnClickListener {
                itemClickListener.invoke(item.id)
            }
        }
    }
}