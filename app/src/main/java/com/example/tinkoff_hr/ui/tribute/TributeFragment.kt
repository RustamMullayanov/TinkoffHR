package com.example.tinkoff_hr.ui.tribute

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.actionbar.SettingsActivity
import com.example.tinkoff_hr.databinding.FragmentTributeBinding
import com.example.tinkoff_hr.ui.tribute.data.Education
import com.example.tinkoff_hr.ui.tribute.data.EducationLarge
import com.example.tinkoff_hr.ui.tribute.data.MeetUp
import com.example.tinkoff_hr.ui.tribute.data.MeetUpLarge
import com.example.tinkoff_hr.ui.tribute.item.EducationItem
import com.example.tinkoff_hr.ui.tribute.item.MeetUpItem
import com.example.tinkoff_hr.ui.tribute.item.TitleItem
import com.example.tinkoff_hr.utils.ui.Dp
import com.example.tinkoff_hr.utils.ui.PaddingItemDecoration
import com.example.tinkoff_hr.utils.ui.dpToPx

class TributeFragment : Fragment(R.layout.fragment_tribute) {
    private lateinit var binding: FragmentTributeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTributeBinding.bind(view)
        setHasOptionsMenu(true)
        val adapter = MyListAdapter(clickListener)

        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            PaddingItemDecoration(
                bottom = requireContext().dpToPx(EDUCATION_LIST_BOTTOM_PADDING),
                filter = { holder ->
                    holder.absoluteAdapterPosition == adapter.itemCount - 1
                })
        )

        //хардкод
        val largeEdu = EducationLarge(
            getString(R.string.scala),
            R.drawable.scala,
            getString(R.string.src_tinkoff_scala),
            getString(R.string.pastaEducation)
        )
        var educations = listOf(

            Education(
                getString(R.string.frontend),
                R.drawable.frontend,
                getString(R.string.src_tinkoff_frontend)
            ),
            Education(getString(R.string.ios), R.drawable.ios, getString(R.string.src_tinkoff_ios)),
            Education(getString(R.string.ios), R.drawable.ios, getString(R.string.src_tinkoff_ios))
        )


        val largeMeetUpLarge =
            MeetUpLarge(getString(R.string.meetup), getString(R.string.meetupBigInfo))
        val smallMeetup = listOf(
            MeetUp(getString(R.string.meetupSmallLeft), getString(R.string.text_meetup_info_left)),
            MeetUp(getString(R.string.meetupSmallRight), getString(R.string.text_meetup_info_right))
        )

        adapter.setNewItems(
            listOf(
                TitleItem("Образовательные программы"),
                EducationItem(largeEdu, educations),
                TitleItem("Встречи"),
                MeetUpItem(largeMeetUpLarge, smallMeetup)
            )
        )
    }

    private val clickListener = object : MyListAdapter.ClickListener {
        override fun onTitleItemClicked(id: String) {
            Toast.makeText(
                this@TributeFragment.context,
                "You clicked on item with id: $id",
                Toast.LENGTH_SHORT
            ).show()
        }

        override fun onEducationItemClicked(id: String) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(id))
            startActivity(intent)
        }

        override fun onMeetUpItemClicked(id: String) {
            AlertDialog.Builder(this@TributeFragment.context)
                .setNegativeButton("Cancel") { d, _ ->
                    d.dismiss()
                }
                .setMessage(id)
                .create()
                .show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.action_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_settings -> {
                startActivity(Intent(context, SettingsActivity::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private companion object {
        @Dp
        const val EDUCATION_LIST_BOTTOM_PADDING = 16F
    }

}