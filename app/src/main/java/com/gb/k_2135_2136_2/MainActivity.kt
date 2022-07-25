package com.gb.k_2135_2136_2

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.gb.k_2135_2136_2.databinding.ActivityMainBinding
import com.gb.k_2135_2136_2.lesson6.ThreadsFragment
import com.gb.k_2135_2136_2.view.contentprovider.ContentProviderFragment
import com.gb.k_2135_2136_2.view.maps.MapsFragment
import com.gb.k_2135_2136_2.view.room.WeatherHistoryListFragment
import com.gb.k_2135_2136_2.view.weatherlist.CitiesListFragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging


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

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("@@@", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }
            val token = task.result
            Log.d("@@@", "$token")
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

