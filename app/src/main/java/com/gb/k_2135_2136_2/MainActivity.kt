package com.gb.k_2135_2136_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val field1 = 5
        var field2 = 5
        field1 = 25
        field2 = 235
    }
}

class Test constructor( val i: Int,var ){


}