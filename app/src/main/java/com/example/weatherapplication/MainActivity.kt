package com.example.weatherapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapplication.databinding.ActivityMainBinding
import com.example.weatherapplication.presentation.adapter.CityAdapter
import com.example.weatherapplication.presentation.viewmodel.CityViewModel
import com.example.weatherapplication.presentation.viewmodel.CityViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: CityViewModelFactory
    @Inject
    lateinit var cityAdapter: CityAdapter
    lateinit var viewModel: CityViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this,factory)
            .get(CityViewModel::class.java)
    }
}