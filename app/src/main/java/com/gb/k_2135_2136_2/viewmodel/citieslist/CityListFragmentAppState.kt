package com.gb.k_2135_2136_2.viewmodel.citieslist

import com.gb.k_2135_2136_2.domain.Weather

sealed class CityListFragmentAppState {
    data class SuccessOne(val weatherData: Weather) : CityListFragmentAppState()
    data class SuccessMulti(val weatherList: List<Weather>) : CityListFragmentAppState()
    data class Error(val error: Throwable) : CityListFragmentAppState()
    object Loading : CityListFragmentAppState()
}
