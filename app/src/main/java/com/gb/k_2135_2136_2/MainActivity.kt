package com.gb.k_2135_2136_2

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.ButtonBarLayout
import com.gb.k_2135_2136_2.databinding.ActivityMainBinding
import com.gb.k_2135_2136_2.view.weatherlist.WeatherListFragment


internal class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.myRoot)

        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container,WeatherListFragment.newInstance()).commit()
        }
    }

}
