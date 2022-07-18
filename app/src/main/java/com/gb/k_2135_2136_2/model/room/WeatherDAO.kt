package com.gb.k_2135_2136_2.model.room

import android.database.Cursor
import androidx.room.*


@Dao
interface WeatherDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // FIXME создать конфликт
    fun insertRoom(weatherEntity:WeatherEntity)

    @Update
    fun updateRoom(weatherEntity:WeatherEntity)

    @Query("INSERT INTO weather_entity_table (name,lat,lon,temperature,feelsLike) VALUES(:name,:lat,:lon,:temperature,:feelsLike)")
    fun insertNative1(name:String,lat:Double,lon:Double,temperature:Int,feelsLike:Int)

    @Query("INSERT INTO weather_entity_table (id,name,lat,lon,temperature,feelsLike) VALUES(:id,:name,:lat,:lon,:temperature,:feelsLike)")
    fun insertNative2(id:Long,name:String,lat:Double,lon:Double,temperature:Int,feelsLike:Int)

    @Query("SELECT * FROM weather_entity_table WHERE lat=:mLat AND lon=:mLon")
    fun getWeatherByLocation(mLat:Double,mLon:Double):List<WeatherEntity>

    @Query("SELECT * FROM weather_entity_table")
    fun getWeatherAll():List<WeatherEntity>


    /**Start
     * LESSON 9 ContentProvider*/

    @Query("DELETE FROM weather_entity_table WHERE id = :id")
    fun deleteById(id: Long)

    @Query("SELECT id, name, temperature FROM weather_entity_table")
    fun getWeatherCursor(): Cursor

    @Query("SELECT id, name, temperature FROM weather_entity_table WHERE id = :id ") //ORDER BY id DESC LIMIT 1
    fun getWeatherCursor(id: Long): Cursor
    /**End
     * LESSON 9 ContentProvider*/



    // CRUD
    // INSERT INTO table_name (key1,key2) VALUES(value1,value2)
    // SELECT * FROM table_name WHERE key1=1
    // SELECT * FROM table_name WHERE lat IN(30,31,32,40)
    // SELECT * FROM table_name WHERE lat  between 1 and 10
    // UPDATE table_name SET name=newName WHERE key1=1
    // DELETE FROM table_name WHERE key1=1

}