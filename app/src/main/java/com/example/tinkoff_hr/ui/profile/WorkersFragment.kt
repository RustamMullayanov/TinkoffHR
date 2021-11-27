package com.example.tinkoff_hr.ui.profile

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoff_hr.databinding.FragmentWorkersBinding


class WorkersFragment : Fragment() {

    private lateinit var workersViewModel: WorkersViewModel
    private var _binding: FragmentWorkersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        workersViewModel = ViewModelProvider(this).get(WorkersViewModel::class.java)
        _binding = FragmentWorkersBinding.inflate(inflater, container, false)
        val root: View = binding.root



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}