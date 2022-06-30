package com.gb.k_2135_2136_2.lesson4

import android.util.Log
import com.gb.k_2135_2136_2.lesson3.Lesson3

class Lesson4 {
    lateinit var lesson3:Lesson3

    var funField = fun (string: String):Int{
        for(i in 0..100){
            if(i==44) return 0
        }
        return 1
    }

    val funFieldL = hack@{string: String ->
        for(i in 0..100){
            if(i==44) return@hack 0
        }
        return@hack 1
    }

    fun setMyFunField(block:(string: String)->Int){
        this.funField = block
    }

    fun setMyFunFieldString(string: String){

    }

    fun sayHiToLesson3(string: String){
        lesson3.receiveMassage(string)

        lesson3.receiveMassage("$string funField")
    }
}