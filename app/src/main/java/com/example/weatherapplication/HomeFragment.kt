package com.example.weatherapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapplication.databinding.FragmentHomeBinding
import com.example.weatherapplication.presentation.adapter.CityAdapter
import com.example.weatherapplication.presentation.viewmodel.CityViewModel
import com.example.weatherapplication.presentation.viewmodel.CityViewModelFactory
import com.example.weatherapplication.util.Resource
import javax.inject.Inject


class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory : CityViewModelFactory
    @Inject
    lateinit var cityAdapter: CityAdapter
    private lateinit var viewModel: CityViewModel
    private   lateinit var fragmentHomeBinding: FragmentHomeBinding
    private var isLoading = false
    private var lebanonLat : Double = 33.3
    private var lebanonLon : Double = 33.5
    private var api = "245ee60863f0e320995f8dedb437005a"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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
    }

    private fun viewCityList() {
        viewModel.getCity(lebanonLat,lebanonLon,api)
        viewModel.city.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Success -> {

                    hideProgressBar()
                    it.data?.let {
                        cityAdapter.addCity(listOf(it))
                    }
                }
               is Resource.Error->{
                    hideProgressBar()
                    it.message?.let {
                        Toast.makeText(activity,"An error occurred : $it", Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        },)
    }

    private fun initRecyclerView() {

    }

    private fun showProgressBar(){
        isLoading = true
        fragmentHomeBinding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        isLoading = false
        fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
    }


}
