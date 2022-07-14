package com.gb.k_2135_2136_2.utils

import com.gb.k_2135_2136_2.domain.City
import com.gb.k_2135_2136_2.domain.Weather
import com.gb.k_2135_2136_2.model.dto.Fact
import com.gb.k_2135_2136_2.model.dto.WeatherDTO
import java.io.BufferedReader
import java.util.stream.Collectors

fun getLines(reader: BufferedReader): String {
    return reader.lines().collect(Collectors.joining("\n"))
}

fun bindDTOWithCity(weatherDTO: WeatherDTO,city: City): Weather {
    val fact: Fact = weatherDTO.fact
    return (Weather(city, fact.temp, fact.feelsLike))
}

fun convertModelToDto(weather: Weather): WeatherDTO {
    val fact: Fact = Fact(weather.feelsLike, weather.temperature)
    return WeatherDTO(fact)
}