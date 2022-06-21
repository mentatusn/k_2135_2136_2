package com.gb.k_2135_2136_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatButton


internal class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<AppCompatButton>(R.id.btn).setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

            }
        } )

        val dataClass1= NoteKotlin("ewrhru","wefgweg",R.color.black)
        val dataClass2 = dataClass1.copy(color = R.color.teal_200, note = "fdsghderh")

        val andrej = object  {
            val name = "Andrej"
            var age = 20
        }
        andrej.age= 21
        //View.OnClickListener


    }
}

//class Test constructor(val vali: Int,var vari: Int){}
open class Test() {

    protected open val protString =""

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

object SingleNewTest{
    public val protString:String=""
}
class NewTest(field0: String,field2: String):Test(field0,field2){

    public override val protString:String=""

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

    companion object {
        const val staticField = "erhrw6j"
    }
}


class Button @JvmOverloads constructor(context: Context,attributeSet: AttributeSet?=null,defStyleAttr:Int=0)