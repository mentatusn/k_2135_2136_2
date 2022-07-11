package com.gb.k_2135_2136_2.view.weatherlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gb.k_2135_2136_2.databinding.FragmentWeatherListRecyclerItemBinding
import com.gb.k_2135_2136_2.domain.Weather
import com.gb.k_2135_2136_2.view.details.OnItemClick

class DetailsListAdapter(private val dataList:List<Weather>, private val callback: OnItemClick):RecyclerView.Adapter<DetailsListAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding= FragmentWeatherListRecyclerItemBinding.inflate(LayoutInflater.from(parent.context))
        return WeatherViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class WeatherViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bind(weather: Weather){
            val binding= FragmentWeatherListRecyclerItemBinding.bind(itemView)
            binding.cityName.text = weather.city.name
            binding.root.setOnClickListener {
                callback.onItemClick(weather)
            }
        }
    }
}