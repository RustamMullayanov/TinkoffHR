package com.example.tinkoff_hr.ui.where_eat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.FragmentWhereEatBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

import com.google.android.gms.maps.model.MarkerOptions




class WhereEatFragment : Fragment() , OnMapReadyCallback{

    private var _binding: FragmentWhereEatBinding? = null
    private lateinit var googleMap: GoogleMap
    private var mapReady = false

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

       // binding.mapWhereEat.onStart()
       // val mapFragment = childFragmentManager.findFragmentById(R.id.map_where_eat) as SupportMapFragment

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