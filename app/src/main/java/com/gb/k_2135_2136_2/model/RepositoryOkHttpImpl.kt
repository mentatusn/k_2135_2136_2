package com.gb.k_2135_2136_2.model

import com.gb.k_2135_2136_2.BuildConfig
import com.gb.k_2135_2136_2.domain.City
import com.gb.k_2135_2136_2.model.dto.WeatherDTO
import com.gb.k_2135_2136_2.utils.YANDEX_API_KEY
import com.gb.k_2135_2136_2.utils.bindDTOWithCity
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class RepositoryOkHttpImpl:RepositoryWeatherByCity {
    override fun getWeather(city: City, callback: CommonWeatherCallback) {
        val client = OkHttpClient()
        val builder = Request.Builder()
        builder.addHeader(YANDEX_API_KEY, BuildConfig.WEATHER_API_KEY)
        builder.url("https://api.weather.yandex.ru/v2/informers?lat=${city.lat}&lon=${city.lon}")
        val request: Request = builder.build()
        val call: Call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback.onFailure(e)
            }
            override fun onResponse(call: Call, response: Response) {
                //if (response.isSuccessful) { }
                if (response.code in 200..299 && response.body != null) {
                    response.body?.let {
                        val responseString = it.string()
                        val weatherDTO =
                            Gson().fromJson((responseString), WeatherDTO::class.java)
                        callback.onResponse(bindDTOWithCity(weatherDTO,city))
                    }
                } else {
                    // TODO HW callback.on??? 403 404
                    callback.onFailure(IOException("403 404"))
                }
            }
        })
    }
}

