package com.example.tinkoff_hr.ui.workers

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.CardWorkerNewBinding
import com.example.tinkoff_hr.domain.entities.worker.Worker

class WorkerAdapter(private val clickListener: (Worker) -> Unit) :
    RecyclerView.Adapter<WorkerAdapter.WorkerHolder>() {
    private var workers: List<Worker> = emptyList()

    // only for preview
    private val projectNames: Map<Int, String> = mapOf(
        1 to "Мобильный Банк Android",
        2 to "Тинькофф для Бизнеса",
        3 to "Тинькофф Инвестиции",
        4 to "Тинькофф Мобайл",
        5 to "Голосовой помощник Олег",
        6 to "Направление нефинансовых сервисов",
        7 to "Проект управления нефинансовыми сервисами",
    )

    class WorkerHolder(val viewBinding: CardWorkerNewBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerHolder {
        val binding =
            CardWorkerNewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return WorkerHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkerHolder, position: Int) {
        val item = workers[position]
        with(holder.viewBinding) {

            nameFieldWorker.text = "${item.surname} ${item.name} ${item.patronymic ?: ""}"
            functionFieldWorker.text = item.function
            projectFieldWorker.text = projectNames[item.project] ?: ""
            photoWorker.setImageResource(R.drawable.ic_account_circle_24)
        }

        holder.itemView.setOnClickListener {
            clickListener.invoke(item)
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