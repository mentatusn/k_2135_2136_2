package com.gb.k_2135_2136_2.model.dto


import com.google.gson.annotations.SerializedName

data class WeatherDTO(
    val fact: Fact,
    val forecast: Forecast,
    val info: Info,
    val now: Int,
    @SerializedName("now_dt")
    val nowDt: String
)