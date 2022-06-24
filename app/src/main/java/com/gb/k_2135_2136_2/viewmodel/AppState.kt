package com.gb.k_2135_2136_2.viewmodel

import com.gb.k_2135_2136_2.domain.Weather

sealed class AppState {
    data class Success(val weatherData: Weather) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
