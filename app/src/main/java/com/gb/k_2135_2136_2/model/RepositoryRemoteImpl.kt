package com.gb.k_2135_2136_2.model

import com.gb.k_2135_2136_2.domain.Weather
import com.gb.k_2135_2136_2.domain.getRussianCities
import com.gb.k_2135_2136_2.domain.getWorldCities
import com.gb.k_2135_2136_2.viewmodel.AppState

class RepositoryRemoteImpl:RepositoryOne {

    override fun getWeather(lat: Double, lon: Double): Weather {
        Thread{
            Thread.sleep(300L)
        }.start()
        return Weather()
    }
}