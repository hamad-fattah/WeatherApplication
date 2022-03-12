package com.example.weatherapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplication.data.model.CityResponse
import com.example.weatherapplication.databinding.CityListItemBinding

class CityAdapter:RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    private val data = ArrayList<CityResponse>()

    fun addCity(city: List<CityResponse>) {
        data.addAll(city)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding = CityListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class CityViewHolder(
        val binding: CityListItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(city:CityResponse){
            binding.cityName.text = city.name
        }
    }

}