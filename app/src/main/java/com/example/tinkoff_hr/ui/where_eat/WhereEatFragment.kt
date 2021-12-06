package com.example.tinkoff_hr.ui.where_eat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.databinding.FragmentWhereEatBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.material.bottomsheet.BottomSheetBehavior


class WhereEatFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentWhereEatBinding? = null
    private val eateryAdapter = EateryAdapter()
    private lateinit var googleMap: GoogleMap

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentWhereEatBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val bottomSheetBehavior = BottomSheetBehavior.from(binding.sheet.bottomSheetWhereEat)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN)
                    binding.btnExpend.show()
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                    binding.btnExpend.show()
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })


        binding.sheet.recEatery.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = eateryAdapter
        }

        binding.btnExpend.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            binding.btnExpend.hide()
        }



        eateryAdapter.addList(
            listOf(
                Eatery(6.0, "Рада"),
                Eatery(5.3, "А ты где?"),
                Eatery(8.1, "Ситора"),
                Eatery(8.0, "Японамама"),
                Eatery(7.5, "Рататуй"),
                Eatery(9.3, "Пан Пицца"),
                Eatery(8.2, "KFC"),
                Eatery(6.0, "Рада"),
                Eatery(5.3, "А ты где?"),
                Eatery(8.1, "Ситора"),
                Eatery(8.0, "Японамама"),
                Eatery(7.5, "Рататуй"),
                Eatery(9.3, "Пан Пицца"),
                Eatery(8.2, "KFC"),
            )
        )
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
    }
}