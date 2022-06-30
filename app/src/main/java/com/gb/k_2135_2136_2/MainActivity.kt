package com.gb.k_2135_2136_2

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ViewAnimator
import androidx.appcompat.app.AppCompatActivity
import com.gb.k_2135_2136_2.databinding.ActivityMainBinding
import com.gb.k_2135_2136_2.lesson3.Lesson3
import com.gb.k_2135_2136_2.lesson4.*
import com.gb.k_2135_2136_2.view.weatherlist.WeatherListFragment


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

        val lesson1 = Lesson1()
        val lesson2 = Lesson2()
        val lesson3 = Lesson3()
        val lesson4 = Lesson4()

        lesson4.sayHiToLessonN(object : Speakable{
            override fun say(string: String) {
            }
        })

        lesson4.sayHiToLessonN{}
        lesson4.sayHiToLessonN(lesson3)
        lesson4.sayHiToLessonN(lesson2)
        lesson4.sayHiToLessonN(lesson1)

        binding.myRoot.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
            }
        })
        binding.myRoot.setOnClickListener {  }



    }

}
