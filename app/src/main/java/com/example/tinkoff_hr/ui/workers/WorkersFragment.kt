package com.example.tinkoff_hr.ui.workers

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.FragmentWorkersBinding
import com.example.tinkoff_hr.domain.entities.worker.WorkerItem
import com.example.tinkoff_hr.domain.entities.worker.WorkerStatus
import com.example.tinkoff_hr.presentation.WorkersPresenter
import com.example.tinkoff_hr.ui.workers.worker_profile.WorkerProfileActivity
import com.example.tinkoff_hr.views.WorkersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class WorkersFragment : MvpAppCompatFragment(R.layout.fragment_workers), WorkersView {

    @Inject
    lateinit var presenterProvider: Provider<WorkersPresenter>

    private val workersPresenter by moxyPresenter { presenterProvider.get() }

    private lateinit var binding: FragmentWorkersBinding
    private lateinit var workerAdapter: WorkerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWorkersBinding.bind(view)

        workerAdapter = WorkerAdapter(clickListener)

        with(binding) {
            recWorkers.apply {
                layoutManager = LinearLayoutManager(this.context)
                adapter = workerAdapter
            }

            textSearch.setEndIconOnClickListener {
                val workerName = fieldSearch.text.toString()
                workersPresenter.filterWorkersByName(workerName)
            }

            fieldSearch.addTextChangedListener {
                if (fieldSearch.text.toString().isEmpty())
                    workersPresenter.filterWorkersByName("")
            }
        }
    }

    override fun showWorkersInfo(workers: List<WorkerItem>) {
        workerAdapter.setNewItems(workers)
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private val clickListener = object : WorkerAdapter.ClickListener {

        override fun onWorkerClicked(workerId: String) {
            startActivity(WorkerProfileActivity.createIntent(requireContext(), workerId))
        }

    }
}