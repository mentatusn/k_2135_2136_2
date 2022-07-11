package com.gb.k_2135_2136_2.model

import com.gb.k_2135_2136_2.domain.Weather

fun interface RepositoryDetails {
    fun getWeather(lat: Double, lon: Double):Weather
}

fun interface RepositoryOne {
    fun getWeather( lat: Double, lon: Double):Weather
}
fun interface RepositoryCitiesList {
    fun getListCities(location:Location):List<Weather>
}

sealed class Location{
    object Russian:Location()
    object World:Location()
}