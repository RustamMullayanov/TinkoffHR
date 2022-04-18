package com.example.tinkoff_hr.ui.workers

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.databinding.FragmentWorkersBinding
import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.entities.worker.WorkerStatus
import com.example.tinkoff_hr.presentation.WorkersPresenter
import com.example.tinkoff_hr.ui.workers.worker_profile.WorkerProfileActivity
import com.example.tinkoff_hr.views.WorkersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class WorkersFragment : MvpAppCompatFragment(), WorkersView {

    @Inject
    lateinit var presenterProvider: Provider<WorkersPresenter>

    private val workersPresenter by moxyPresenter { presenterProvider.get() }

    private var _binding: FragmentWorkersBinding? = null
    private lateinit var workerAdapter: WorkerAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)

        workerAdapter = WorkerAdapter { worker ->
            startActivity(WorkerProfileActivity.createIntent(requireContext(), worker))
        }

        /*workerAdapter.setList(
            listOf(
                Worker(
                    "1",
                    "mail",
                    "Ivan",
                    "Kurtka",
                    "Ivanovich",
                    null,
                    "WoT",
                    "1",
                    "cybersport",
                    "the best",
                    WorkerStatus.ACTIVE
                ),
                Worker(
                    "1",
                    "mail",
                    "Ivan",
                    "Kurtka",
                    "Ivanovich",
                    null,
                    "WoT",
                    "1",
                    "cybersport",
                    "the best",
                    WorkerStatus.ACTIVE
                ),
                Worker(
                    "1",
                    "mail",
                    "Ivan",
                    "Kurtka",
                    "Ivanovich",
                    null,
                    "WoT",
                    "1",
                    "cybersport",
                    "the best",
                    WorkerStatus.ACTIVE
                ),
                Worker(
                    "1",
                    "mail",
                    "Ivan",
                    "Kurtka",
                    "Ivanovich",
                    null,
                    "WoT",
                    "1",
                    "cybersport",
                    "the best",
                    WorkerStatus.ACTIVE
                ),
                Worker(
                    "1",
                    "mail",
                    "Ivan",
                    "Kurtka",
                    "Ivanovich",
                    null,
                    "WoT",
                    "1",
                    "cybersport",
                    "the best",
                    WorkerStatus.ACTIVE
                ),
                Worker(
                    "1",
                    "mail",
                    "Ivan",
                    "Kurtka",
                    "Ivanovich",
                    null,
                    "WoT",
                    "1",
                    "cybersport",
                    "the best",
                    WorkerStatus.ACTIVE
                ),
            )
        )*/
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

        binding.textSearch.setEndIconOnClickListener {
            val workerName = binding.fieldSearch.text.toString()
            workersPresenter.filterWorkersByName(workerName)
        }

        binding.fieldSearch.addTextChangedListener {
            if (binding.fieldSearch.text.toString().isEmpty())
                workersPresenter.filterWorkersByName("")
        }

        return root
    }

    override fun showWorkersInfo(workers: List<Worker>) {
        workerAdapter.setList(workers)
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}