package com.example.tinkoff_hr.ui.workers

import android.app.Activity
import android.content.Context
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.ContentActivity
import com.example.tinkoff_hr.databinding.FragmentWorkersBinding
import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.presentation.ProfilePresenter
import com.example.tinkoff_hr.presentation.WorkersPresenter
import com.example.tinkoff_hr.views.WorkersView
import moxy.MvpAppCompatFragment
import moxy.MvpFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class WorkersFragment : MvpAppCompatFragment(), WorkersView {

    @Inject
    lateinit var presenterProvider: Provider<WorkersPresenter>

    private val workersPresenter by moxyPresenter { presenterProvider.get() }

    private var _binding: FragmentWorkersBinding? = null
    private val workerAdapter = WorkerAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?){
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recWorkers.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = workerAdapter
        }
        return root
    }

    override fun showWorkersInfo(workers: List<Worker>) {
        workerAdapter.addList(workers)
        //TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}