package com.gb.k_2135_2136_2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.gb.k_2135_2136_2.databinding.ActivityMainBinding
import com.gb.k_2135_2136_2.lesson6.ThreadsFragment
import com.gb.k_2135_2136_2.view.contentprovider.ContentProviderFragment
import com.gb.k_2135_2136_2.view.maps.MapsFragment
import com.gb.k_2135_2136_2.view.room.WeatherHistoryListFragment
import com.gb.k_2135_2136_2.view.weatherlist.CitiesListFragment


internal class MainActivity : AppCompatActivity() {




    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.myRoot)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CitiesListFragment.newInstance()).commit()
        }

        pushNotification("title","body")
    }

    val CHANNEL_HIGH_ID = "channel_we3tw43"
    val CHANNEL_LOW_ID = "channel_rey"
    val NOTIFICATION_ID1 = 1
    val NOTIFICATION_ID2 = 1

    private fun pushNotification(title:String, body:String){
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(this,CHANNEL_HIGH_ID).apply {
            setContentTitle(title)
            setContentText(body)
            setSmallIcon(R.drawable.ic_kotlin_logo)
            priority = NotificationCompat.PRIORITY_MAX
            //intent = PendingIntent() TODO HW по клику на push - открыть MainActivity
        }

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channelHigh = NotificationChannel(CHANNEL_HIGH_ID,CHANNEL_HIGH_ID,NotificationManager.IMPORTANCE_HIGH)
            channelHigh.description = "Канал для бла бла бла"
            notificationManager.createNotificationChannel(channelHigh)
        }

        notificationManager.notify(NOTIFICATION_ID1,notification.build())


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channelLow = NotificationChannel(CHANNEL_LOW_ID,CHANNEL_LOW_ID,NotificationManager.IMPORTANCE_LOW)
            channelLow.description = "Канал LOW для бла бла бла"
            notificationManager.createNotificationChannel(channelLow)
        }
        notificationManager.notify(NOTIFICATION_ID2,notification.build())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_screen_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_threads -> {
                supportFragmentManager.apply {
                    beginTransaction()
                        .add(R.id.container, ThreadsFragment())
                        .addToBackStack("")
                        .commitAllowingStateLoss()
                }
                true
            }
            R.id.menu_history -> {
                supportFragmentManager.apply {
                    beginTransaction()
                        .replace(R.id.container, WeatherHistoryListFragment())
                        .addToBackStack("")
                        .commitAllowingStateLoss()
                }
                true
            }

            R.id.menu_content_provider-> {
                supportFragmentManager.apply {
                    beginTransaction()
                        .replace(R.id.container, (ContentProviderFragment()))
                        .addToBackStack("")
                        .commitAllowingStateLoss()
                }
                true
            }

            R.id.menu_google_maps-> {
                supportFragmentManager.apply {
                    beginTransaction()
                        .replace(R.id.container, (MapsFragment()))
                        .addToBackStack("")
                        .commitAllowingStateLoss()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}

