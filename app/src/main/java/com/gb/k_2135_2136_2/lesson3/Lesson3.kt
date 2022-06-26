package com.gb.k_2135_2136_2.lesson3

object Lesson3 {


    ///lateinit var i:Int
    var testJava: Test? = null
    var testJava2: Test = Test()
    var testKotlin: Test

    init {
        testKotlin = Test()
    }

    fun startLesson() {

        //val strange: Test = null!! // однажды Хемингуэй поспорил...

        testJava = null
        if (testJava != null) {
            testJava = null // хоть senior из джавы и пишут везде if (testJava != null), но это не гарантия
            val response: String? = testJava?.serverResponse()
            val responseShoot: String = testJava!!.serverResponse() // никто не запретит сделать глупость !!
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
            testJava = null // хоть senior из джавы и пишут везде if (testJava != null), но это не гарантия
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

}