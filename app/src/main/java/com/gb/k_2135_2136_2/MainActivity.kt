package com.gb.k_2135_2136_2

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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
        getToken()
    }

    private fun getToken() {
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
                navigationTo(ThreadsFragment())
                true
            }
            R.id.menu_history -> {
                navigationTo(WeatherHistoryListFragment())
                true
            }

            R.id.menu_content_provider -> {
                navigationTo(ContentProviderFragment())
                true
            }

            R.id.menu_google_maps -> {
                navigationTo(MapsFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun navigationTo(fr: Fragment) {
        supportFragmentManager.apply {
            beginTransaction()
                .add(R.id.container, fr)
                .addToBackStack("")
                .commitAllowingStateLoss()

            val s = Soldier("eregh")

            s.instrument?.run {
                excavate()
            }

            foo(Soldier("eregh"))

            foo(SoldierWithShovel("eregh"))
        }
    }


}

abstract class Shovel{
    abstract fun excavate()
}
sealed class Instruments:Shovel() {
    data class ShovelThin(val type: Int) : Instruments(){
        override fun excavate() {
// особенности
        }
    }
    data class ShovelWide(val type: Int) : Instruments(){
        override fun excavate() {
// особенности
        }
    }
}

fun interface Runnable {
    fun run()
}

fun interface Flyable {
    fun fly()
}

fun interface Excavate {
    fun excavate()
}

fun foo(soldier: Flyable) {
    soldier.fly()
}

open class Soldier(val name: String) : Flyable {
    val instrument: Instruments? = null
    fun calc() {
        getWork()
    }

    open fun getWork() {
        //
    }

    fun getWork2() {
        //
    }

    fun build() {
        getWork()
    }

    override fun fly() {
        TODO("Not yet implemented")
    }
}



class SoldierWithShovel(name: String) : Soldier(name) {
    override fun getWork() {
        // что-то сломали
    }
}

class SoldierWithBrush(name: String) : Soldier(name) {
}




