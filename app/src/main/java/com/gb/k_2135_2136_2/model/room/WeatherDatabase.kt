package com.gb.k_2135_2136_2.model.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(WeatherEntity::class), version = 1)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao():WeatherDAO
}