package com.gb.k_2135_2136_2.model

import com.gb.k_2135_2136_2.domain.Weather
import com.gb.k_2135_2136_2.domain.getDefaultCity

class RepositoryDetailsRetrofitImpl:RepositoryDetails {
    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather(getDefaultCity())
    }
}

