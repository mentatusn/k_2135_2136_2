package com.gb.k_2135_2136_2.viewmodel.weatherhistorylist

import com.gb.k_2135_2136_2.domain.Weather

sealed class WeatherHistoryListFragmentAppState {
    data class SuccessMulti(val weatherList: List<Weather>) : WeatherHistoryListFragmentAppState()
    data class Error(val error: Throwable) : WeatherHistoryListFragmentAppState()
    object Loading : WeatherHistoryListFragmentAppState()
}
