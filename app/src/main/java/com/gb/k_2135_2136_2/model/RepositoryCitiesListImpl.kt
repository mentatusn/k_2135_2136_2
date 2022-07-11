package com.gb.k_2135_2136_2.model


import com.gb.k_2135_2136_2.domain.Weather
import com.gb.k_2135_2136_2.domain.getRussianCities
import com.gb.k_2135_2136_2.domain.getWorldCities

class RepositoryCitiesListImpl : RepositoryCitiesList {
    override fun getListCities(location: Location): List<Weather> {
        return when (location) {
            Location.Russian -> {
                getRussianCities()
            }
            Location.World -> {
                getWorldCities()
            }
        }
    }
}