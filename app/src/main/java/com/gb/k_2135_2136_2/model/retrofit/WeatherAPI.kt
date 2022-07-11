package com.gb.k_2135_2136_2.model.retrofit

import com.gb.k_2135_2136_2.model.dto.WeatherDTO
import com.gb.k_2135_2136_2.utils.YANDEX_API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WeatherAPI {

    @GET("/v2/informers")
    fun getWeather(
        @Header(YANDEX_API_KEY) keyValue: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ):Call<WeatherDTO>

    @GET("/v2/informers")
    fun getWeather2(
        @Header(YANDEX_API_KEY) keyValue: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ):Call<WeatherDTO>

    @GET("/v2/informers")
    fun getWeather3(
        @Header(YANDEX_API_KEY) keyValue: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ):Call<WeatherDTO>

    @GET("/v2/informers")
    fun getWeather4(
        @Header(YANDEX_API_KEY) keyValue: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ):Call<WeatherDTO>

}