package com.gb.k_2135_2136_2.model

import com.gb.k_2135_2136_2.BuildConfig
import com.gb.k_2135_2136_2.domain.City
import com.gb.k_2135_2136_2.model.dto.WeatherDTO
import com.gb.k_2135_2136_2.utils.YANDEX_API_KEY
import com.gb.k_2135_2136_2.utils.bindDTOWithCity
import com.gb.k_2135_2136_2.utils.getLines
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class RepositoryWeatherLoaderImpl: RepositoryWeatherByCity {
    override fun getWeather(city: City, callback: CommonWeatherCallback) {
        Thread {
            val uri = URL("https://api.weather.yandex.ru/v2/informers?lat=${city.lat}&lon=${city.lon}")
            var myConnection: HttpsURLConnection? = null
            myConnection = uri.openConnection() as HttpsURLConnection
            try {
                myConnection.readTimeout = 5000
                myConnection.addRequestProperty(YANDEX_API_KEY, "44ce48ce-54e0-4425-a528-474919b19e2b")

                val reader = BufferedReader(InputStreamReader(myConnection.inputStream))
                val weatherDTO = Gson().fromJson(getLines(reader), WeatherDTO::class.java)
                callback.onResponse(bindDTOWithCity(weatherDTO,city))
            }catch (e:IOException){
                callback.onFailure(e)
            }finally {
                myConnection.disconnect()
            }
        }.start()
    }

}