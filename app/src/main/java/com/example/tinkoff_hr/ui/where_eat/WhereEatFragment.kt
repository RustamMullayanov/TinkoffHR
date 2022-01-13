package com.example.tinkoff_hr.ui.where_eat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.FragmentWhereEatBinding
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.presentation.restaurant.WhereEatPresenter
import com.example.tinkoff_hr.ui.where_eat.eatery_information.EateryInformationActivity
import com.example.tinkoff_hr.views.restaurant.WhereEatView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class WhereEatFragment : MvpAppCompatFragment(), WhereEatView, OnMapReadyCallback {

    @Inject
    lateinit var presenterProvider: Provider<WhereEatPresenter>

    private val whereEatPresenter by moxyPresenter { presenterProvider.get() }

    private var _binding: FragmentWhereEatBinding? = null
    private lateinit var eateryAdapter: EateryAdapter
    private lateinit var googleMap: GoogleMap

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)

        eateryAdapter = EateryAdapter { id ->
            startActivity(EateryInformationActivity.createIntent(requireContext(), id))

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

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
        
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.map_where_eat) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        val ural = LatLng(56.833332, 60.583332)
        map.addMarker(
            MarkerOptions()
                .position(ural)
                .title("Marker in Ural")
        )
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(ural, 16.0F))
    }

    override fun setRestaurantsInfo(restaurants: List<Restaurant>) {
        eateryAdapter.setList(restaurants)
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}