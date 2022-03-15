package com.example.weatherapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplication.R
import com.example.weatherapplication.data.model.CityResponse
import com.example.weatherapplication.databinding.CityListItemBinding

class CityAdapter:RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    private val data = ArrayList<CityResponse>()
    private val cityName = "Beirut"

    fun addCity(city: List<CityResponse>) {
        data.addAll(city)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding = CityListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class CityViewHolder(
        private val binding: CityListItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(city: CityResponse) {
            binding.cityName.text = city.name
            binding.cityTemp.text = String.format(itemView.context.getText(R.string.lblTemp).toString(),
            "${city.main.temp}")
            binding.cityHumidity.text = String.format(itemView.context.getText(R.string.lblHumidity).toString(),
                "${city.main.humidity}")
            binding.cityWind.text = String.format(itemView.context.getText(R.string.lblWind).toString(),
                "${city.wind.speed}")

        }
    }
}
