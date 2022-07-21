package com.gb.k_2135_2136_2.model

import com.gb.k_2135_2136_2.MyApp
import com.gb.k_2135_2136_2.domain.City
import com.gb.k_2135_2136_2.domain.Weather
import com.gb.k_2135_2136_2.model.room.WeatherEntity

class RepositoryRoomImpl : RepositoryWeatherByCity, RepositoryWeatherSave,
    RepositoryWeatherAvailable {
    override fun getWeather(city: City, callback: CommonWeatherCallback) {
        callback.onResponse(
            MyApp.getWeatherDatabase().weatherDao().getWeatherByLocation(city.lat, city.lon).let {
                if(it.isNotEmpty()){
                    convertHistoryEntityToWeather(it).last()
                }else{
                    Weather(city)//FIXME не всегда в room может быть погода
                }
            })
    }

    override fun addWeather(weather: Weather) {
        MyApp.getWeatherDatabase().weatherDao().insertRoom(convertWeatherToEntity(weather))
    }

    override fun getWeatherAll(callback: CommonListWeatherCallback) {
        callback.onResponse(
            convertHistoryEntityToWeather(
                MyApp.getWeatherDatabase().weatherDao().getWeatherAll()
            )
        )
    }

    private fun convertHistoryEntityToWeather(entityList: List<WeatherEntity>): List<Weather> {
        /* val answer = mutableListOf<WeatherDTO>()
         entityList.forEach {
             answer.add(WeatherDTO(Fact(it.feelsLike,it.temperature)))
         }*/
        return entityList.map {
            Weather(City(it.name, it.lat, it.lon), it.temperature, it.feelsLike)
        }
    }

    private fun convertWeatherToEntity(weather: Weather): WeatherEntity {
        return WeatherEntity(
            0,
            weather.city.name,
            weather.city.lat,
            weather.city.lon,
            weather.temperature,
            weather.feelsLike
        )
    }


}

