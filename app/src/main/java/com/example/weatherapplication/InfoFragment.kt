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
    private lateinit var viewModel: CityViewModel

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
        viewModel = (activity as MainActivity).viewModel
        binding.apply {
            cityName1.text = city.name
            cityTemp1.text = city.main.temp.toString()
            cityHumidity1.text = city.main.humidity.toString()
            cityWind1.text = city.wind.speed.toString()
        }
    }
}