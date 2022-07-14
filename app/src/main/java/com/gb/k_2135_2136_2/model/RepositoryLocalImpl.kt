package com.gb.k_2135_2136_2.model

import com.gb.k_2135_2136_2.domain.City

import com.gb.k_2135_2136_2.domain.getRussianCities
import com.gb.k_2135_2136_2.domain.getWorldCities

class RepositoryLocalImpl:RepositoryWeatherByCity {
    override fun getWeather(city: City, callback: CommonWeatherCallback) {
        val list = getWorldCities().toMutableList()
        list.addAll(getRussianCities())
        val response = list.filter { it.city.lat==city.lat&&it.city.lon==city.lon  }
        callback.onResponse((response.first()))
    }
}