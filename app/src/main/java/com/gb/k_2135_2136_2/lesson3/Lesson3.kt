package com.gb.k_2135_2136_2.lesson3

import android.util.Log
import android.view.ViewGroup


interface TestableKotlin {
    fun foo()
    var field: String
    fun fooAdv() {
        field = ""
    }
}

class Lesson3Old : TestableKotlin {


    fun receiveMassage(string: String) {
        Log.d("@@@", " получили $string")
    }

    val funField = fun (string: String):Int{
        return Log.d("@@@", " получили $string")
    }


    ///lateinit var i:Int
    var testJava: Test? = null
    var testJava2: Test = Test()
    var testKotlin: Test

    init {
        testKotlin = Test()
    }

    fun startLessonGeneric() {
        val startList: List<*>
        startList = listOf<String>("I", "love", "Kotlin")
        var phraseList = listOf<String>("I", "love", "Kotlin")
        var numList = listOf<Int>(3, 5, 2, 9, 45, 23, 1)
        var testList = listOf<Test>(Test(), Test(), Test(), Test())

        someGeneric("")
        someGeneric(Test())
        someGeneric(1.0)


        var uniLink: Producer<Any>

        val producerTest = Producer<Test>()
        val producerString = Producer<String>()

        uniLink = producerTest
        uniLink = producerString
        uniLink.produce()


    }

    class Producer<out T> {
        private val list: List<T> = listOf<T>()
        fun produce(): T {
            return list.first()
        }
    }

    class Consumer<in T> {
        fun consume(input: T) {

        }
    }

    fun some(input: String) {
        Log.d("@@@", input.toString())
    }

    fun some(input: Test) {
        Log.d("@@@", input.toString())
    }

    fun some(input: Double) {
        Log.d("@@@", input.toString())
    }

    private fun <MyT> someGeneric(input: MyT) {
        Log.d("@@@", input.toString())
    }

    fun <V : ViewGroup> someGenericView(input: V) {
        Log.d("@@@", input.toString())
    }

    fun startLessonInterface() {
        //val callback = TestableKotlin { }
        val callbackJava = TestableJava {}
    }

    fun startLessonCollections() {
        fooAdv()
        var phraseArray = arrayOf("I", "love", "Kotlin")
        var phraseList = listOf("I", "love", "Kotlin")
        var numList = listOf(3, 5, 2, 9, 45, 23, 1)
        val phraseListMutable = mutableListOf("I", "love", "Kotlin")
        var phraseMap = mapOf("I" to "2", "love" to "2", "Kotlin" to "2")

        phraseList = phraseList.toMutableList()
        phraseListMutable.add("")
        phraseListMutable.removeAt(0)

        val newFilteredPhraseList = phraseList.filter { it.length > 3 }
        val newList = phraseList.map { "$it," }
        val newFilteredNumList = numList.sorted()
        val first = numList.first()
        val last = numList.last()

        val lat: Double = 1.0
        val lon: Double = 2.0

        val location = Pair(lat, lon)
        location.first
        location.second
        val locationAnotherOne = lat to lon
        locationAnotherOne.first
        locationAnotherOne.second
    }

    fun startLesson(): Unit {
        val anyLink: Any = testKotlin
        (anyLink as Test).fooRun()
        //val strange: Test = null!! // однажды Хемингуэй поспорил...
        /*
        :Nothing - если ничего не планировали возвращать
        throw IllegalStateException()
        while(true){
        }
        startLesson()*/
        testJava = null
        if (testJava != null) {
            testJava =
                null // хоть senior из джавы и пишут везде if (testJava != null), но это не гарантия
            val response: String? = testJava?.serverResponse()
            val responseShoot: String =
                testJava!!.serverResponse() // никто не запретит сделать глупость !!
            val responseKotlin: String = response ?: "none" // челка сверху
        }

        // мы не знаем String? или String был в java, поэтому на свое усмотрени
        val strNull: String? = testJava2.fooRun()
        val strNotNull: String = testJava2.fooRun()

        //testKotlin = null

        val testNullable: Test? = null
        if (testJava != null) {
            testJava = null
            testKotlin = testJava!!
        }
        testKotlin = testJava ?: Test() // челка сверху

        testKotlin = if (testJava != null) {
            testJava =
                null // хоть senior из джавы и пишут везде if (testJava != null), но это не гарантия
            testJava!!//nullpointer
        } else {
            Test()
        }

        if (testNullable != null) {//всегда false
            testKotlin = testNullable
            testKotlin.fooRun()// nullpointer
        }
    }

    fun setupTestJava(testJava: Test?) {
        if (testJava != null) {
            testKotlin = testJava
        }
    }

    fun foo(s: String) {}

    fun fooRun() {
        foo(null!!)
    }

    override fun foo() {
        TODO("Not yet implemented")
    }

    override var field: String
        get() = TODO("Not yet implemented")
        set(value) {}

}