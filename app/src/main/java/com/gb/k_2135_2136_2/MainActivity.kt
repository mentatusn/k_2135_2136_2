package com.gb.k_2135_2136_2

import android.content.Context
import android.content.SyncRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val field1 = 5
        var field2 = 5

        field2 = 235

        val test1:Test = Test()
        test1.name()
    }
}

//class Test constructor(val vali: Int,var vari: Int){}
class Test @JvmOverloads constructor() {

    constructor(field: String):this()
    constructor(field: String,field2: String):this(field)
    constructor(field: String,field2: String,field3: String):this(field,field2)

    private lateinit var vali: String
    //var vari: Int
    fun name(){
        vali = "какое-то значение"
        Log.d("@@@",vali)
    }
}




class Button @JvmOverloads constructor(context: Context,attributeSet: AttributeSet?=null,defStyleAttr:Int=0)