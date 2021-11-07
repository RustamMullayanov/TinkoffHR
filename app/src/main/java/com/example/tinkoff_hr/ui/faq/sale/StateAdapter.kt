package com.example.tinkoff_hr.ui.faq.sale

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoff_hr.databinding.StateItemBinding

class StateAdapter : RecyclerView.Adapter<StateAdapter.StateHolder>() {

    private var states: List<State> = emptyList()

    class StateHolder(val viewBinding: StateItemBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateHolder {
        val binding = StateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return StateHolder(binding)
    }

    override fun onBindViewHolder(holder: StateHolder, position: Int) {
        with(holder.viewBinding) {
            expandButton.setText(states[position].name)
            expandButton.setOnClickListener {
                expandableLayout.toggle()
            }

            textInfo.text = states[position].information
            imageLogo.setImageResource(states[position].fotoResource)
        }
    }


    override fun getItemCount(): Int {
        return states.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<State>) {
        states = list
        notifyDataSetChanged()
    }
}