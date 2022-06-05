package com.example.tinkoff_hr.ui.where_eat

import android.Manifest
import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.actionbar.SettingsActivity
import com.example.tinkoff_hr.databinding.FragmentWhereEatBinding
import com.example.tinkoff_hr.presentation.restaurant.WhereEatPresenter
import androidx.appcompat.app.AppCompatActivity
import com.example.tinkoff_hr.ui.where_eat.eatery_information.EateryInformationActivity
import com.example.tinkoff_hr.views.restaurant.WhereEatView
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import android.location.LocationManager
import androidx.core.location.LocationManagerCompat
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


class WhereEatFragment : MvpAppCompatFragment(R.layout.fragment_where_eat), WhereEatView,
    OnMapReadyCallback {

    @Inject
    lateinit var presenterProvider: Provider<WhereEatPresenter>

    private val whereEatPresenter by moxyPresenter { presenterProvider.get() }

    private lateinit var eateryAdapter: EateryAdapter
    private lateinit var googleMap: GoogleMap
    private lateinit var binding: FragmentWhereEatBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val bottomSheetBehavior by lazy { BottomSheetBehavior.from(binding.sheet.bottomSheetWhereEat) }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWhereEatBinding.bind(view)
        setHasOptionsMenu(true)
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.map_where_eat) as SupportMapFragment
        mapFragment.getMapAsync(this)

        eateryAdapter = EateryAdapter(clickListener)

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

        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        map.uiSettings.isMyLocationButtonEnabled = false
        map.addMarker(
            MarkerOptions().position(LatLng(56.772343, 60.58886)).title("Остановка Полисадная")
        )
        map.moveCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLngYekaterinburg,
                CityZoom
            )
        )

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this.requireContext())
        binding.btnExpend.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            binding.btnExpend.hide()

            if (ContextCompat.checkSelfPermission(
                    this.requireContext(), Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                if (isLocationEnabled(this.requireActivity()))
                    fusedLocationClient.lastLocation.addOnSuccessListener { l ->
                        map.moveCamera(
                            CameraUpdateFactory.newLatLngZoom(LatLng(l.latitude, l.longitude), 13f)
                        )
                    }
                else {
                    val locationRequest = LocationRequest.create()
                    locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

                    val builder = LocationSettingsRequest.Builder()
                        .addLocationRequest(locationRequest)

                    val task = LocationServices.getSettingsClient(this.requireContext())
                        .checkLocationSettings(builder.build())

                    task.addOnFailureListener { e ->
                        if (e is ResolvableApiException) {
                            try {
                                Toast.makeText(
                                    this.requireContext(),
                                    R.string.turn_on_gps_app_determine_location,
                                    Toast.LENGTH_SHORT
                                ).show()
                                e.startResolutionForResult(
                                    this.requireActivity(),
                                    REQUEST_LOCATION_SETTING
                                )
                            } catch (sendEx: IntentSender.SendIntentException) {
                            }
                        }
                    }
                }
            } else
                ActivityCompat.requestPermissions(
                    this.requireActivity(),
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    REQUEST_CODE_LOCATION
                )

        }
        getLocationAccess()
    }

    private fun isLocationEnabled(context: Context): Boolean {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return LocationManagerCompat.isLocationEnabled(locationManager)
    }

    private fun getLocationAccess() {
        if (ContextCompat.checkSelfPermission(
                this.requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            googleMap.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                this.requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE_LOCATION) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                if (ActivityCompat.checkSelfPermission(
                        this.requireContext(),
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this.requireContext(),
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {

                    return
                }
                googleMap.isMyLocationEnabled = true
            } else {
                Toast.makeText(this.requireContext(), R.string.allow_location, Toast.LENGTH_SHORT)
                    .show()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_LOCATION_SETTING) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this.requireContext(), R.string.gps_on, Toast.LENGTH_SHORT).show()
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(
                    this.requireContext(),
                    R.string.app_not_determine_location,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun setRestaurantsInfo(restaurants: List<RestaurantItem>) {
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

    companion object {
        private const val REQUEST_CODE_LOCATION = 1
        private const val REQUEST_LOCATION_SETTING = 999
        private val LatLngYekaterinburg = LatLng(56.838248, 60.603481)
        private const val CityZoom = 16f
    }
}