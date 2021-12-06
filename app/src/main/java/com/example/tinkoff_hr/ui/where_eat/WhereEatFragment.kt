package com.example.tinkoff_hr.ui.where_eat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.databinding.FragmentWhereEatBinding
import com.example.tinkoff_hr.ui.where_eat.eatery_information.EateryInformationActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.material.bottomsheet.BottomSheetBehavior


class WhereEatFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentWhereEatBinding? = null
    private lateinit var eateryAdapter: EateryAdapter
    private lateinit var googleMap: GoogleMap

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        eateryAdapter = EateryAdapter { id ->
            startActivity(EateryInformationActivity.createIntent(requireContext(), id))
        }
    }

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
                /*if (slideOffset<0.45) {
                    if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_DRAGGING)
                        onStateChanged(bottomSheet, BottomSheetBehavior.STATE_HIDDEN)
                }*/
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
                Eatery(1, 6.0, "Рада", true, 203.4, ""),
                Eatery(2, 5.3, "А ты где?", false, 100.0, ""),
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