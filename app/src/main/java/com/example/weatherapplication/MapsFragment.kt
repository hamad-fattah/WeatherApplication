package com.example.weatherapplication

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.weatherapplication.data.model.CityResponse
import com.example.weatherapplication.data.model.Coord
import com.example.weatherapplication.databinding.FragmentMapsBinding
import com.example.weatherapplication.presentation.adapter.CityAdapter
import com.example.weatherapplication.presentation.viewmodel.CityViewModel
import com.example.weatherapplication.util.Resource
import java.math.BigDecimal
import java.math.RoundingMode
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class MapsFragment : Fragment() {

    private lateinit var binding: FragmentMapsBinding
    private lateinit var viewModel: CityViewModel
    private lateinit var cityAdapter : CityAdapter
    private val callback = OnMapReadyCallback { googleMap ->
        googleMap.setOnCameraIdleListener {
            var center : LatLng = googleMap.cameraPosition.target
            binding.button2.setOnClickListener {
                Toast.makeText(context,"${BigDecimal(center.latitude).setScale(2,RoundingMode.HALF_EVEN)} " +
                        ", ${BigDecimal(center.longitude).setScale(2,RoundingMode.HALF_EVEN)}",Toast.LENGTH_LONG).show()
                val savedCity = viewModel.getCity(Coord(center.latitude,center.longitude))
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
        viewModel = (activity as MainActivity).viewModel
        cityAdapter= (activity as MainActivity).cityAdapter
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)


    }
}
