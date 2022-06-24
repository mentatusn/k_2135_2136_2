package com.gb.k_2135_2136_2.model

import com.gb.k_2135_2136_2.domain.Weather

class RepositoryLocalImpl:Repository {
    override fun getListWeather(): List<Weather> {
        return listOf(Weather())
    }

    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }
}