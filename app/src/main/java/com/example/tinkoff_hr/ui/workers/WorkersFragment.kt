package com.example.tinkoff_hr.ui.workers

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.databinding.FragmentWorkersBinding
import com.example.tinkoff_hr.domain.entities.Worker


class WorkersFragment : Fragment() {

    private var _binding: FragmentWorkersBinding? = null
    private val workerAdapter = WorkerAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
                    "",
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
                    "",
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
                    "",
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
                    "",
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
                    "",
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
                    "",
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
                    "",
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
                    "",
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