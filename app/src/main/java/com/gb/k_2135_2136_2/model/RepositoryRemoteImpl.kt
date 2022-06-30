package com.gb.k_2135_2136_2.model

import com.gb.k_2135_2136_2.domain.Weather

class RepositoryRemoteImpl:RepositoryOne {

    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }
}