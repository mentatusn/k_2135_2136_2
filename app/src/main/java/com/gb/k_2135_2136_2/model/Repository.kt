package com.gb.k_2135_2136_2.model

import com.gb.k_2135_2136_2.domain.City
import com.gb.k_2135_2136_2.domain.Weather
import java.io.IOException

fun interface RepositoryWeatherByCity {
    fun getWeather(city: City,callback: CommonWeatherCallback)
}

fun interface RepositoryWeatherAvailable {
    fun getWeatherAll(callback: CommonListWeatherCallback)
}

fun interface RepositoryWeatherSave {
    fun addWeather(weather: Weather)
}


interface CommonWeatherCallback{
    fun onResponse(weather: Weather)
    fun onFailure(e: IOException)
}

interface CommonListWeatherCallback{
    fun onResponse(weather: List<Weather>)
    fun onFailure(e: IOException)
}

fun interface RepositoryCitiesList {
    fun getListCities(location:Location):List<Weather>
}

sealed class Location{
    object Russian:Location()
    object World:Location()
}