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
import com.example.weatherapplication.domain.usecase.GetCityUseCase
import com.example.weatherapplication.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class CityViewModel(
    private val app:Application,
    private val getCityUseCase: GetCityUseCase)
    : AndroidViewModel(app)
 {
     val city: MutableLiveData<Resource<CityResponse>> = MutableLiveData()
     fun getCity(lat:Double,lon:Double,appid:String) =
         viewModelScope.launch(Dispatchers.IO) {
             city.postValue(Resource.Loading())
             try{
                 if(isNetworkAvailable(app)) {

                     val apiResult = getCityUseCase.execute(lat,lon,appid)
                     city.postValue(apiResult)
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