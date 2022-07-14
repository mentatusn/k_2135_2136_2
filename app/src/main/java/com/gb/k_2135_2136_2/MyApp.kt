package com.gb.k_2135_2136_2

import android.app.Application

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        myApp = this
    }

    companion object{
        private var myApp:MyApp?=null
        fun getMyApp() = myApp!!
    }
}