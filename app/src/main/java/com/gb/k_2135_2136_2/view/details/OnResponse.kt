package com.gb.k_2135_2136_2.view.details

import com.gb.k_2135_2136_2.model.dto.WeatherDTO

fun interface OnResponse {
    fun onResponse(weather: WeatherDTO)
}