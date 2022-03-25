package com.example.weatherapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.weatherapplication.databinding.FragmentInfoBinding
import com.example.weatherapplication.presentation.viewmodel.CityViewModel

class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentInfoBinding.bind(view)
        val args : InfoFragmentArgs by navArgs()
        val city = args.selectedCity
        binding.apply {
            cityName.text = city.name
            binding.cityTemp.text = String.format(context?.getText(R.string.lblTempInfo).toString(),
                "${city.main.temp}")
            binding.cityHumidity.text = String.format(context?.getText(R.string.lblHumidityInfo).toString(),
                "${city.main.humidity}")
            binding.cityWind.text = String.format(context?.getText(R.string.lblWindInfo).toString(),
                "${city.wind.speed}")
        }
    }
}