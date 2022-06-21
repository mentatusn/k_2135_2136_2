package com.gb.k_2135_2136_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val field1 = 5




        val test:Test = Test()
        val newTest = NewTest("","")
        test.name()
        Log.d("@@@","${newTest is NewTest}")// instanceOf
        newTest.newField = "srgerwg"
        Log.d("@@@@",newTest.newField)// cast
    }
}

//class Test constructor(val vali: Int,var vari: Int){}
open class Test() {

    constructor(field: String):this()
    constructor(field: String,field2: String):this(field)
    constructor(field: String,field2: String,field3: String):this(field,field2)

    private lateinit var valI: String
    //var vari: Int
    fun name(){
        valI = "какое-то значение"
        Log.d("@@@",valI)
    }
}

class NewTest(field0: String,field2: String):Test(field0,field2){
    var newField:String = ""
    get() {
        return "$field get"
    }
    set(value) {
        field = "$value set"
    }


    init{
        newField = "newField "
    }
}




class Button @JvmOverloads constructor(context: Context,attributeSet: AttributeSet?=null,defStyleAttr:Int=0)