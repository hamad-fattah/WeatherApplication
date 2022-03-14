package com.example.weatherapplication.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.data.model.CityResponse
import com.example.weatherapplication.data.model.Coord
import com.example.weatherapplication.domain.usecase.CityUseCase
import com.example.weatherapplication.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class CityViewModel(
    private val app:Application,
    private val cityUseCase: CityUseCase)
    : AndroidViewModel(app)
 {
     val city: MutableLiveData<Resource<HashMap<Coord, CityResponse>>> = MutableLiveData()
     fun getCity(vararg citiesCoord: Coord) =
         viewModelScope.launch(Dispatchers.IO) {
             city.postValue(Resource.Loading())
             try{
                 if(isNetworkAvailable(app)) {
                     val citiesWeather = HashMap<Coord, CityResponse>()
                     for (coord in citiesCoord){
                         cityUseCase.requestCityWeather(coord.lat, coord.lon).data?.let {
                             citiesWeather[coord] = it
                         }
                     }
                     city.postValue(Resource.Success(citiesWeather))
                 }else{
                     city.postValue(Resource.Error("Internet is not available"))
                 }

             }catch (e: Exception){
                 city.postValue(Resource.Error(e.message.toString()))
             }

         }

     private fun isNetworkAvailable(context: Context?):Boolean{
         if (context == null) return false
         val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
             val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
             if (capabilities != null) {
                 when {
                     capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                         return true
                     }
                     capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                         return true
                     }
                     capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                         return true
                     }
                 }
             }
         } else {
             val activeNetworkInfo = connectivityManager.activeNetworkInfo
             if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                 return true
             }
         }
         return false

     }
}