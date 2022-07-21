package com.gb.k_2135_2136_2

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.gb.k_2135_2136_2.model.room.WeatherDatabase
import com.gb.k_2135_2136_2.utils.ROOM_DB_NAME_WEATHER

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        myApp = this
    }

    companion object {
        private var myApp: MyApp? = null
        private var weatherDatabase: WeatherDatabase? = null
        fun getMyApp() = myApp!!
        fun getWeatherDatabase(): WeatherDatabase {
            if (weatherDatabase == null) {
                weatherDatabase = Room.databaseBuilder(
                    getMyApp(),
                    WeatherDatabase::class.java,
                    ROOM_DB_NAME_WEATHER
                )
                    .allowMainThreadQueries() // TODO HW убрать allowMainThreadQueries
                    .addMigrations(MIGRATION_1_2)
                    .addMigrations(MIGRATION_1_2)
                    .build()
            }
            return weatherDatabase!!
        }

        val MIGRATION_1_2 = object :Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE weather_entity_table ADD COLUMN icon INTEGER NOT NULL DEFAULT ${R.drawable.ic_russia}")
            }
        }
    }


}