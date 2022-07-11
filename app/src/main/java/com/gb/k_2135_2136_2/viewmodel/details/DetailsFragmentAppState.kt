package com.gb.k_2135_2136_2.viewmodel.details

import com.gb.k_2135_2136_2.domain.Weather

sealed class DetailsFragmentAppState {
    data class Success(val weatherData: Weather) : DetailsFragmentAppState()
    data class Error(val error: Throwable) : DetailsFragmentAppState()
    object Loading : DetailsFragmentAppState()
}
