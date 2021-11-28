package com.example.tinkoff_hr.ui.profile

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.FragmentWorkersBinding
import com.example.tinkoff_hr.domain.entities.Worker


class WorkersFragment : Fragment() {

    private lateinit var workersViewModel: WorkersViewModel
    private var _binding: FragmentWorkersBinding? = null
    private val workerAdapter = WorkerAdapter()
    private val photoArray by lazy {
        arrayOf(
            R.drawable.ic_account_circle_24,
        )
    }

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

        binding.recWorkers.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = workerAdapter
        }

        workerAdapter.addList(
            listOf(
                Worker(
                    "mail.ru",
                    "Андрей",
                    "Крыш",
                    "Константинович",
                    photoArray[0].toString(),
                    "Мобильное приложение",
                    1,
                    "Мобильный разработчик",
                    "",
                    ""
                ),
                Worker(
                    "google.com",
                    "Муллаянов",
                    "Рустам",
                    "Радикович",
                    photoArray[0].toString(),
                    "Мобильное приложение",
                    2,
                    "Мобильный разработчик",
                    "",
                    ""
                ),
                Worker(
                    "mail.ru",
                    "Андрей",
                    "Крыш",
                    "Константинович",
                    photoArray[0].toString(),
                    "Мобильное приложение",
                    1,
                    "Мобильный разработчик",
                    "",
                    ""
                ),
                Worker(
                    "google.com",
                    "Муллаянов",
                    "Рустам",
                    "Радикович",
                    photoArray[0].toString(),
                    "Мобильное приложение",
                    2,
                    "Мобильный разработчик",
                    "",
                    ""
                ),
                Worker(
                    "mail.ru",
                    "Андрей",
                    "Крыш",
                    "Константинович",
                    photoArray[0].toString(),
                    "Мобильное приложение",
                    1,
                    "Мобильный разработчик",
                    "",
                    ""
                ),
                Worker(
                    "google.com",
                    "Муллаянов",
                    "Рустам",
                    "Радикович",
                    photoArray[0].toString(),
                    "Мобильное приложение",
                    2,
                    "Мобильный разработчик",
                    "",
                    ""
                ),
                Worker(
                    "mail.ru",
                    "Андрей",
                    "Крыш",
                    "Константинович",
                    photoArray[0].toString(),
                    "Мобильное приложение",
                    1,
                    "Мобильный разработчик",
                    "",
                    ""
                ),
                Worker(
                    "google.com",
                    "Муллаянов",
                    "Рустам",
                    "Радикович",
                    photoArray[0].toString(),
                    "Мобильное приложение",
                    2,
                    "Мобильный разработчик",
                    "",
                    ""
                ),
            )
        )

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}