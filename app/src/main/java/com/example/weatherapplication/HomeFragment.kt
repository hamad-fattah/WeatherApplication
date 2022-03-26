package com.example.weatherapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.weatherapplication.data.model.Coord
import com.example.weatherapplication.databinding.FragmentHomeBinding
import com.example.weatherapplication.presentation.adapter.CityAdapter
import com.example.weatherapplication.presentation.viewmodel.CityViewModel
import com.example.weatherapplication.presentation.viewmodel.CityViewModelFactory
import com.example.weatherapplication.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory : CityViewModelFactory
    @Inject
    lateinit var cityAdapter: CityAdapter
    private lateinit var viewModel: CityViewModel
    private   lateinit var fragmentHomeBinding: FragmentHomeBinding
    private var isLoading = false
    private val beirutCoord : Coord = Coord(33.8938,35.5018)
    private val parisCoord : Coord = Coord(48.8566,2.3522)
    private val romeCoord : Coord = Coord(41.9028,12.4964)
    private val madridCoord : Coord = Coord(40.4168,3.7038)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentHomeBinding = FragmentHomeBinding.bind(view)
        viewModel= (activity as MainActivity).viewModel
        cityAdapter= (activity as MainActivity).cityAdapter
        ViewModelProvider(this, viewModelFactory).get(CityViewModel::class.java)
        initRecyclerView()
        viewCityList()
        fragmentHomeBinding.btnHomeToMap.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mapsFragment)
        }
        cityAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected_city",it)
            }
            findNavController().navigate(
                R.id.action_homeFragment_to_infoFragment,
                bundle
            )
        }

    }

    private fun viewCityList() {
        defaultForecast()
        viewModel.city.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {

                    hideProgressBar()
                    it.data?.let { data ->
                        cityAdapter.addCity(data.values.toList())
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    it.message?.let { error ->
                        Log.e(HomeFragment::class.java.name, error)
                        Toast.makeText(activity, "An error occurred : $error", Toast.LENGTH_LONG)
                            .show()
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        }
    }

    private fun initRecyclerView() {
        fragmentHomeBinding.rvCities.apply {
            adapter = cityAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
        }
    }

    private fun showProgressBar(){
        isLoading = true
        fragmentHomeBinding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        isLoading = false
        fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
    }
    private fun defaultForecast() {
            viewModel.requestForecast(
            Coord(beirutCoord.lat, beirutCoord.lon),
            Coord(parisCoord.lat, parisCoord.lon),
            Coord(romeCoord.lat, romeCoord.lon),
            Coord(madridCoord.lat,madridCoord.lon)
        ) }
}