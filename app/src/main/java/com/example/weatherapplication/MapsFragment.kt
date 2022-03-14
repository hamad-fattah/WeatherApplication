package com.example.weatherapplication

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.weatherapplication.databinding.FragmentMapsBinding
import java.math.BigDecimal
import java.math.RoundingMode
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class MapsFragment : Fragment() {

    private lateinit var binding: FragmentMapsBinding
    private val callback = OnMapReadyCallback { googleMap ->
        googleMap.setOnCameraIdleListener {
            var center : LatLng = googleMap.cameraPosition.target
            binding.button2.setOnClickListener {
                Toast.makeText(context,"${BigDecimal(center.latitude).setScale(2,RoundingMode.HALF_EVEN)} " +
                        ", ${BigDecimal(center.longitude).setScale(2,RoundingMode.HALF_EVEN)}",Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMapsBinding.bind(view)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)


    }
}