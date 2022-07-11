package com.gb.k_2135_2136_2.model

import com.gb.k_2135_2136_2.domain.Weather
import com.gb.k_2135_2136_2.domain.getDefaultCity
import com.gb.k_2135_2136_2.domain.getRussianCities
import com.gb.k_2135_2136_2.domain.getWorldCities
import com.gb.k_2135_2136_2.model.dto.Fact
import com.gb.k_2135_2136_2.model.dto.WeatherDTO

class RepositoryDetailsLocalImpl:RepositoryDetails {
    override fun getWeather(lat: Double, lon: Double, callback: MyLargeSuperCallback) {
        val list = getWorldCities().toMutableList()
        list.addAll(getRussianCities())
        val response = list.filter { it.city.lat==lat&&it.city.lon==lon  }
        callback.onResponse(convertModelToDto(response.first()))
    }
    private  fun convertDtoToModel(weatherDTO: WeatherDTO): Weather {
        val fact: Fact = weatherDTO.fact
        return (Weather(getDefaultCity(), fact.temp, fact.feelsLike))
    }

    private fun convertModelToDto(weather:Weather): WeatherDTO{
        val fact: Fact = Fact(weather.feelsLike,weather.temperature)
        return WeatherDTO(fact)
    }

}