package com.gb.k_2135_2136_2.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "weather_entity_table")
data class WeatherEntity(
    @PrimaryKey( autoGenerate = true)
    val id: Long=0,
    val name: String="",
    val lat: Double=1.0,
    val lon: Double=1.0,
    var temperature: Int=0,
    var feelsLike: Int=1
)

