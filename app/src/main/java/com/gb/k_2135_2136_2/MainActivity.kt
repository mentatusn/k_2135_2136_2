package com.gb.k_2135_2136_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton


internal class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<AppCompatButton>(R.id.btn).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
            }
        })
        val field4 = 1..100
        val field5 = 5
        val WTV = when (field5) {
            in field4 -> {
                "входит"
            }
            else -> {
                "не входит"
            }
        }

        val dataClass1 = NoteKotlin("ewrhru", "wefgweg", R.color.black)
        val dataClass2 = dataClass1.copy(color = R.color.teal_200, note = "fdsghderh")

        val andrej = object {
            val name = "Andrej"
            var age = 20
        }
        andrej.age = 21
        //View.OnClickListener

        var result = ""
        myToStringJava(andrej.age)

        val enumEl = WeatherType.CLOUDY
        val today = when (enumEl) {
            WeatherType.SUNNY -> TODO()
            WeatherType.RAINY -> TODO()
            WeatherType.CLOUDY -> {
                "облачно"
            }
            WeatherType.MISTY -> TODO()
            WeatherType.SNOWY -> TODO()
            WeatherType.HAILY -> TODO()
        }

        /*циклы*/
        val daysOfWeek = listOf("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
        Log.d("@@@","-------------")
        daysOfWeek.forEach {
            Log.d("@@@","$it")
        }
        Log.d("@@@","-------------")
        repeat(daysOfWeek.size) {
            Log.d("@@@","${daysOfWeek[it]}")
        }
        Log.d("@@@","-------------")
        for(i in daysOfWeek){
            Log.d("@@@","$i ")
        }
        Log.d("@@@","-------------")
        for(i in daysOfWeek.indices){
            Log.d("@@@","${daysOfWeek[i]}")
        }

        Log.d("@@@","-------------")
        for(i in 0.. daysOfWeek.size-1){
            Log.d("@@@","${daysOfWeek[i]}")
        }
        Log.d("@@@","-------------")
        for(i in 0 until daysOfWeek.size){
            Log.d("@@@","${daysOfWeek[i]}")
        }

        Log.d("@@@","-------------")
        for(i in daysOfWeek.size-1 downTo 0){
            Log.d("@@@","${daysOfWeek[i]}")
        }

        Log.d("@@@","-------------")
        for(i in daysOfWeek.size-1 until 0 step 1){ // TODO что-то странное
            Log.d("@@@","${daysOfWeek[i]}")
        }
        var counter = daysOfWeek.size-1
        while (--counter>0){
            Log.d("@@@","${daysOfWeek[counter]}")
        }

        counter = daysOfWeek.size-1
        do{
            Log.d("@@@","${daysOfWeek[counter]}")
        }while (--counter>0)

    }

    enum class WeatherType {
        SUNNY,
        RAINY,
        CLOUDY,
        MISTY,
        SNOWY,
        HAILY
    }


    fun myToStringJava(age: Int): String { // java подход
        var result = ""
        if (age == 20) {
            result = "двадцать"
        } else {
            result = "не двадцать"
        }
        return result
    }

    fun myToStringKotlin(age: Int): String { // java подход
        return if (age == 20) {
            "двадцать"
            "двадцать";
            "двадцать"
        } else {
            "не двадцать"
        }
    }
}

//class Test constructor(val vali: Int,var vari: Int){}
open class Test() {

    protected open val protString = ""

    constructor(field: String) : this()
    constructor(field: String, field2: String) : this(field)
    constructor(field: String, field2: String, field3: String) : this(field, field2)

    private lateinit var valI: String

    //var vari: Int
    fun name() {
        valI = "какое-то значение"
        Log.d("@@@", valI)
    }
}

object SingleNewTest {
    public val protString: String = ""
}

class NewTest(field0: String, field2: String) : Test(field0, field2) {

    public override val protString: String = ""

    var newField: String = ""
        get() {
            return "$field get"
        }
        set(value) {
            field = "$value set"
        }


    init {
        newField = "newField "
    }

    companion object {
        const val staticField = "erhrw6j"
    }
}


class Button @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
)