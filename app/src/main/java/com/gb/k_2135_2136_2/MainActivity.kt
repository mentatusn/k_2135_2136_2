package com.gb.k_2135_2136_2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gb.k_2135_2136_2.databinding.ActivityMainBinding
import com.gb.k_2135_2136_2.lesson4.Lesson4
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


        val lesson4=Lesson4()
        val result = lesson4.myWork()
        val result2 = getResult(lesson4)
        val result3 = getResult(lesson4)
        repeat(100){
            Log.d("@@@","${(0..3).random(Random(System.currentTimeMillis()))} ff")
        }
    }

    private fun getResult(lesson4: Lesson4) {
        run({
            lesson4.lesson3
        })
    }

    fun Lesson4.myWork(){
        run({
            this.lesson3
        })
    }
}

