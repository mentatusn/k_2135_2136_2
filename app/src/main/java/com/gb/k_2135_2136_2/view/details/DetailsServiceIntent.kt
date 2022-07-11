package com.gb.k_2135_2136_2.view.details

import android.app.IntentService
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.gb.k_2135_2136_2.BuildConfig
import com.gb.k_2135_2136_2.domain.City
import com.gb.k_2135_2136_2.model.dto.WeatherDTO
import com.gb.k_2135_2136_2.utils.*
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import javax.net.ssl.HttpsURLConnection



class DetailsServiceIntent : IntentService("") {

    override fun onHandleIntent(intent: Intent?) {

        intent?.let {
            it.getParcelableExtra<City>(BUNDLE_CITY_KEY)?.let {

                try {
                    val uri = URL("https://api.weather.yandex.ru/v2/informers?lat=${it.lat}&lon=${it.lon}")
                    Thread {
                        var myConnection: HttpsURLConnection? = null
                        myConnection = uri.openConnection() as HttpsURLConnection
                        try {
                            myConnection.readTimeout = 5000
                            myConnection.addRequestProperty(
                                YANDEX_API_KEY,
                                BuildConfig.WEATHER_API_KEY
                            )

                            val reader = BufferedReader(InputStreamReader(myConnection.inputStream))
                            val weatherDTO =
                                Gson().fromJson(getLines(reader), WeatherDTO::class.java)

                            LocalBroadcastManager.getInstance(this).sendBroadcast(Intent().apply {
                                putExtra(BUNDLE_WEATHER_DTO_KEY, weatherDTO)
                                action = WAVE
                            })

                        } catch (e: MalformedURLException) {

                        } catch (e: IOException) {

                        } catch (e: JsonSyntaxException) {

                        } finally {
                            myConnection.disconnect()
                        }
                    }.start()
                }catch (e: MalformedURLException){

                }
            }

        }
    }


}