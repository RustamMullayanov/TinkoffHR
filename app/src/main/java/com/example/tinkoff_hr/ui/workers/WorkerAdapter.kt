package com.example.tinkoff_hr.ui.workers

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.CardWorkerBinding
import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.ui.workers.worker_profile.WorkerProfileActivity

class WorkerAdapter(private val clickListener: (String) -> Unit) :
    RecyclerView.Adapter<WorkerAdapter.WorkerHolder>() {
    private var workers: List<Worker> = emptyList()

    class WorkerHolder(val viewBinding: CardWorkerBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerHolder {
        val binding = CardWorkerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return WorkerHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkerHolder, position: Int) {
        val item = workers[position]
        with(holder.viewBinding) {

            nameFieldWorker.text = "${item.surname} ${item.name} ${item.patronymic}"
            functionFieldWorker.text = item.function
            projectFieldWorker.text = item.project
            photoWorker.setImageResource(R.drawable.ic_account_circle_24)
        }

        holder.itemView.setOnClickListener {
            clickListener.invoke(item.email)
        }
    }

    override fun getItemCount(): Int {
        return workers.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Worker>) {
        workers = list
        notifyDataSetChanged()
    }

}