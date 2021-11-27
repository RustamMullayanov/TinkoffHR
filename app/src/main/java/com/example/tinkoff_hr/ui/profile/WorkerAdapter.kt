package com.example.tinkoff_hr.ui.profile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoff_hr.databinding.CardWorkerBinding
import com.example.tinkoff_hr.domain.entities.Worker

class WorkerAdapter : RecyclerView.Adapter<WorkerAdapter.WorkerHolder>() {
    private var workers: List<Worker> = emptyList()

    class WorkerHolder(val viewBinding: CardWorkerBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerHolder {
        val binding = CardWorkerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return WorkerHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkerHolder, position: Int) {
        with(holder.viewBinding) {
            val item = workers[position]
            nameFieldWorker.text = "${item.surname} ${item.name} ${item.patronymic}"
            functionFieldWorker.text = item.function
            projectFieldWorker.text = item.project
            photoWorker.setImageResource(item.photo.toInt())
        }
    }

    override fun getItemCount(): Int {
        return workers.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<Worker>) {
        workers = list
        notifyDataSetChanged()
    }
}