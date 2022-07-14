package com.gb.k_2135_2136_2.model.retrofit

import com.gb.k_2135_2136_2.BuildConfig
import com.gb.k_2135_2136_2.domain.City
import com.gb.k_2135_2136_2.model.CommonWeatherCallback
import com.gb.k_2135_2136_2.model.RepositoryWeatherByCity
import com.gb.k_2135_2136_2.model.dto.WeatherDTO
import com.gb.k_2135_2136_2.utils.bindDTOWithCity
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class RepositoryLocationToOneWeatherRetrofitImpl : RepositoryWeatherByCity {
    override fun getWeather(city: City, callback: CommonWeatherCallback) {
        val retrofitImpl = Retrofit.Builder()
        retrofitImpl.baseUrl("https://api.weather.yandex.ru")
        retrofitImpl.addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        val api = retrofitImpl.build().create(WeatherAPI::class.java)
        //api.getWeather(BuildConfig.WEATHER_API_KEY,lat,lon).execute() // синхронный запрос
        api.getWeather(BuildConfig.WEATHER_API_KEY,city.lat,city.lon).enqueue(object :Callback<WeatherDTO>{
            override fun onResponse(call: Call<WeatherDTO>, response: Response<WeatherDTO>) {
                // response.raw().request // тут есть информация - а кто же нас вызвал
                if(response.isSuccessful&&response.body()!=null){
                    callback.onResponse(bindDTOWithCity(response.body()!!,city))
                }else {
                    // TODO HW callback.on??? 403 404
                    callback.onFailure(IOException("403 404"))
                }

            }
            override fun onFailure(call: Call<WeatherDTO>, t: Throwable) {
                callback.onFailure(t as IOException) //костыль
            }
        })
    }
}

