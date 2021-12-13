package com.example.tinkoff_hr.ui.faq

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tinkoff_hr.databinding.FragmentFaqBinding
import com.example.tinkoff_hr.ui.faq.MeetUp.MeetUpActivity
import com.example.tinkoff_hr.ui.faq.education.EducationActivity
import com.example.tinkoff_hr.ui.faq.business_trip.BusinessTripActivity
import com.example.tinkoff_hr.ui.faq.parking.ParkingActivity
import com.example.tinkoff_hr.ui.faq.sale.SaleActivity

class FaqFragment : Fragment() {

    private var _binding: FragmentFaqBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFaqBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonParking.setOnClickListener {
            val intent = Intent(this.context, ParkingActivity::class.java)
            startActivity(intent)
        }

        binding.buttonSales.setOnClickListener {
            val intent = Intent(this.context, SaleActivity::class.java)
            startActivity(intent)
        }

        binding.buttonBusinessTrips.setOnClickListener {
            val intent = Intent(this.context, BusinessTripActivity::class.java)
            startActivity(intent)
        }

        binding.buttonMeetup.setOnClickListener {
            val intent = Intent(this.context, MeetUpActivity::class.java)
            startActivity(intent)
        }

        binding.buttonEducation.setOnClickListener {
            val intent = Intent(this.context, EducationActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}