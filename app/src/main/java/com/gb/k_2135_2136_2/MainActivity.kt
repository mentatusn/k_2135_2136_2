package com.gb.k_2135_2136_2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.gb.k_2135_2136_2.databinding.ActivityMainBinding
import com.gb.k_2135_2136_2.lesson4.Lesson4
import com.gb.k_2135_2136_2.lesson6.BUNDLE_KEY
import com.gb.k_2135_2136_2.lesson6.MyBroadCastReceiver
import com.gb.k_2135_2136_2.lesson6.MyService
import com.gb.k_2135_2136_2.lesson6.ThreadsFragment
import com.gb.k_2135_2136_2.view.weatherlist.WeatherListFragment
import kotlin.random.Random


internal class MainActivity : AppCompatActivity() {




    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.myRoot)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WeatherListFragment.newInstance()).commit()
        }

        startService(Intent(this,MyService::class.java).apply {
            putExtra(BUNDLE_KEY,"Hello")
        })

        val receiver=MyBroadCastReceiver()
        registerReceiver(receiver, IntentFilter("android.intent.action.AIRPLANE_MODE"))
        registerReceiver(receiver, IntentFilter("myaction"))



        LocalBroadcastManager.getInstance(this).registerReceiver(object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                Log.d("@@@"," onReceive ${Thread.currentThread()}")
            }
        }, IntentFilter("answer"))

        sendBroadcast(Intent().apply {
            action = "myaction"
        })
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
            else -> super.onOptionsItemSelected(item)
        }
    }


}

