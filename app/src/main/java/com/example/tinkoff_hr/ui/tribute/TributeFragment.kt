package com.example.tinkoff_hr.ui.tribute

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.databinding.FragmentTributeBinding
import com.example.tinkoff_hr.ui.tribute.item.EducationItem
import com.example.tinkoff_hr.ui.tribute.item.MeetUpItem
import com.example.tinkoff_hr.ui.tribute.item.TitleItem

class TributeFragment : Fragment() {
    private var _binding: FragmentTributeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTributeBinding.inflate(inflater, container, false)
        val adapter = MyListAdapter(clickListener)

        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerView.adapter = adapter


        adapter.setNewItems(
            listOf(
                TitleItem("Образовательные программы"),
                EducationItem(),
                TitleItem("Встречи"),
                MeetUpItem(),
                TitleItem("Встречи"),
                MeetUpItem(),
            )
        )
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    val clickListener = object : MyListAdapter.ClickListener {
        override fun onTitleItemClicked(id: String) {
            Toast.makeText(
                this@TributeFragment.context,
                "You clicked on item with id: $id",
                Toast.LENGTH_SHORT
            ).show()
        }

        override fun onEducationItemClicked(id: String) {
            Toast.makeText(
                this@TributeFragment.context,
                "You clicked on item with id: $id",
                Toast.LENGTH_SHORT
            ).show()
        }

        override fun onMeetUpItemClicked(id: String) {
            Toast.makeText(
                this@TributeFragment.context,
                "You clicked on item with id: $id",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

}