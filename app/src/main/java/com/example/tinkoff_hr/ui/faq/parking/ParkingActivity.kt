package com.example.tinkoff_hr.ui.faq.parking

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ActivityParkingBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.location.LocationManager
import androidx.core.location.LocationManagerCompat
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*


class ParkingActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityParkingBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityParkingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Парковки"

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.uiSettings.isMyLocationButtonEnabled = false
        map.addMarker(
            MarkerOptions().position(LatLng(56.772343, 60.58886)).title("Остановка Полисадная")
        )
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLngYekaterinburg, CityZoom))
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        binding.btnFind.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                if (isLocationEnabled(this))
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

                    val task = LocationServices.getSettingsClient(this)
                        .checkLocationSettings(builder.build())

                    task.addOnFailureListener { e ->
                        if (e is ResolvableApiException) {
                            try {
                                Toast.makeText(
                                    this,
                                    R.string.turn_on_gps_app_determine_location,
                                    Toast.LENGTH_SHORT
                                ).show()
                                e.startResolutionForResult(
                                    this,
                                    REQUEST_LOCATION_SETTING
                                )
                            } catch (sendEx: IntentSender.SendIntentException) {
                            }
                        }
                    }
                }
            } else
                ActivityCompat.requestPermissions(
                    this,
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
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED) {
            map.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                this,
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
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {

                    return
                }
                map.isMyLocationEnabled = true
            } else {
                Toast.makeText(this, R.string.allow_location, Toast.LENGTH_SHORT).show()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_LOCATION_SETTING) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, R.string.gps_on, Toast.LENGTH_SHORT).show()
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, R.string.app_not_determine_location, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val REQUEST_CODE_LOCATION = 1
        private const val REQUEST_LOCATION_SETTING = 999
        private val LatLngYekaterinburg = LatLng(56.838248, 60.603481)
        private const val CityZoom = 10.5f
    }
}