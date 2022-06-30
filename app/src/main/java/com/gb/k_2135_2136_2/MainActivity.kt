package com.gb.k_2135_2136_2

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ViewAnimator
import androidx.appcompat.app.AppCompatActivity
import com.gb.k_2135_2136_2.databinding.ActivityMainBinding
import com.gb.k_2135_2136_2.lesson3.Lesson3
import com.gb.k_2135_2136_2.lesson4.Lesson4
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

        val lesson3 = Lesson3()
        val lesson4 = Lesson4()
        lesson4.lesson3 = lesson3
        lesson4.funField = lesson3.funField
        lesson4.setMyFunField(lesson3.funField) // аналог

        lesson4.sayHiToLesson3("Привет")

        val resultFunField =  lesson4.funField("")
        val resultFunFieldL =  lesson4.funFieldL("")

        val l = { i:Int->
            i
        }

        var lambda :(s:String)->Int

        lambda = lesson4.funField
        lambda = { s:String->
            (1.0).toInt()
        }

        binding.myRoot.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
            }
        })
        binding.myRoot.setOnClickListener {  }

        val test:String = ""
        lesson4.setMyFunFieldString(test)
        lesson4.setMyFunField(lambda)
    }

}
