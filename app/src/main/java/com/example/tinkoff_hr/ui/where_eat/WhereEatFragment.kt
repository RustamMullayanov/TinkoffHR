package com.example.tinkoff_hr.ui.where_eat

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.FragmentWhereEatBinding
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.presentation.restaurant.WhereEatPresenter
import com.example.tinkoff_hr.ui.where_eat.eatery_information.EateryInformationActivity
import com.example.tinkoff_hr.views.restaurant.WhereEatView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.material.bottomsheet.BottomSheetBehavior
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class WhereEatFragment : MvpAppCompatFragment(R.layout.fragment_where_eat), WhereEatView,
    OnMapReadyCallback {

    @Inject
    lateinit var presenterProvider: Provider<WhereEatPresenter>

    private val whereEatPresenter by moxyPresenter { presenterProvider.get() }

    private lateinit var eateryAdapter: EateryAdapter
    private lateinit var googleMap: GoogleMap
    private lateinit var binding: FragmentWhereEatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWhereEatBinding.bind(view)

        eateryAdapter = EateryAdapter(clickListener)
        //хардкод данный
        /*eateryAdapter.setNewItems(
            listOf(
                Restaurant("1", "KFC", 4.5, false, 367.5, 3.3, 3.3),
                Restaurant("1", "KFC", 4.5, false, 367.5, 3.3, 3.3),
                Restaurant("1", "KFC", 4.5, false, 367.5, 3.3, 3.3),
                Restaurant("1", "KFC", 4.5, false, 367.5, 3.3, 3.3),
                Restaurant("1", "KFC", 4.5, false, 367.5, 3.3, 3.3),
                Restaurant("1", "KFC", 4.5, false, 367.5, 3.3, 3.3),
                Restaurant("1", "KFC", 4.5, false, 367.5, 3.3, 3.3),
                Restaurant("1", "KFC", 4.5, false, 367.5, 3.3, 3.3),
                Restaurant("1", "KFC", 4.5, false, 367.5, 3.3, 3.3),
                Restaurant("1", "KFC", 4.5, false, 367.5, 3.3, 3.3),
                Restaurant("1", "KFC", 4.5, false, 367.5, 3.3, 3.3),
                Restaurant("1", "KFC", 4.5, false, 367.5, 3.3, 3.3),

                )
        )*/

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
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
    }

    override fun setRestaurantsInfo(restaurants: List<Restaurant>) {
        eateryAdapter.setNewItems(restaurants)
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private val clickListener = object : EateryAdapter.ClickListener {
        override fun onEateryClicked(id: String) {
            startActivity(EateryInformationActivity.createIntent(requireContext(), id))
        }
    }
}