package com.gb.k_2135_2136_2.view.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gb.k_2135_2136_2.databinding.FragmentWeatherHistoryListRecyclerItemBinding

import com.gb.k_2135_2136_2.domain.Weather
import com.gb.k_2135_2136_2.view.details.OnItemClick

class WeatherHistoryListAdapter(private val dataList:List<Weather>, private val callback: OnItemClick):RecyclerView.Adapter<WeatherHistoryListAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding= FragmentWeatherHistoryListRecyclerItemBinding.inflate(LayoutInflater.from(parent.context))
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
            val binding= FragmentWeatherHistoryListRecyclerItemBinding.bind(itemView)
            binding.cityName.text = weather.city.name
            binding.temperatureValue.text = weather.temperature.toString()
            binding.root.setOnClickListener {
                callback.onItemClick(weather)
            }
        }
    }
}