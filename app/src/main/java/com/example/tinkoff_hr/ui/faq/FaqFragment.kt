package com.example.tinkoff_hr.ui.faq

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.actionbar.SettingsActivity
import com.example.tinkoff_hr.databinding.FragmentFaqBinding
import com.example.tinkoff_hr.ui.faq.MeetUp.MeetUpActivity
import com.example.tinkoff_hr.ui.faq.education.EducationActivity
import com.example.tinkoff_hr.ui.faq.business_trip.BusinessTripActivity
import com.example.tinkoff_hr.ui.faq.parking.ParkingActivity
import com.example.tinkoff_hr.ui.faq.sale.SaleActivity

class FaqFragment : Fragment(R.layout.fragment_faq) {

    private lateinit var binding: FragmentFaqBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFaqBinding.bind(view)
        setHasOptionsMenu(true)

        with(binding) {
            buttonParking.setOnClickListener {
                val intent = Intent(this@FaqFragment.context, ParkingActivity::class.java)
                startActivity(intent)
            }

            buttonSales.setOnClickListener {
                val intent = Intent(this@FaqFragment.context, SaleActivity::class.java)
                startActivity(intent)
            }

            buttonBusinessTrips.setOnClickListener {
                val intent = Intent(this@FaqFragment.context, BusinessTripActivity::class.java)
                startActivity(intent)
            }

            buttonMeetup.setOnClickListener {
                val intent = Intent(this@FaqFragment.context, MeetUpActivity::class.java)
                startActivity(intent)
            }

            buttonEducation.setOnClickListener {
                val intent = Intent(this@FaqFragment.context, EducationActivity::class.java)
                startActivity(intent)
            }
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
}