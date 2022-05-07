package com.example.tinkoff_hr.ui.orders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.FragmentOrdersBinding
import com.example.tinkoff_hr.databinding.FragmentWorkersBinding
import com.example.tinkoff_hr.ui.workers.WorkerAdapter

class OrdersFragment : Fragment(R.layout.fragment_orders) {

    private lateinit var binding: FragmentOrdersBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrdersBinding.bind(view)

    }

}