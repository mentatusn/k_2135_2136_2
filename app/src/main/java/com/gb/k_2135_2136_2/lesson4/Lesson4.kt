package com.gb.k_2135_2136_2.lesson4


fun interface Speakable {
    fun say(string: String)


    fun onCreate() {

        val lesson1 = Lesson1()
        val lesson2 = Lesson2()
        val lesson3 = Lesson3()
        val lesson4 = Lesson4()

        lesson4.sayHiToLessonN(object : Speakable {
            override fun say(string: String) {
            }
        })

        lesson4.sayHiToLessonN {}
        lesson4.sayHiToLessonN(lesson3)
        lesson4.sayHiToLessonN(lesson2)
        lesson4.sayHiToLessonN(lesson1)


        superHighOrderFunction { int: Int, int2: Int, str: String ->
            (int + int2).toDouble()
            (int + int2).toDouble()
            (int + int2).toDouble()
            (int + int2).toDouble() // рузультат лямбды
        }
    }

    private fun highOrderFunction(
        int: (char: Char) -> Number,
        int2: Int,
        str: String
    ): (int: Int) -> Double {
        int('c')
        return { int: Int -> int.toDouble() }
    }

    private fun superHighOrderFunction(block: (int: Int, int2: Int, str: String) -> Double): (int: Int, str: String) -> String { // TODO HW придумать, где такое использовать
        val res = block(1, 1, "")//выполнили полученную на вход функцию
        val resultAnonimFunStaticType: (int: Int, str: String) -> String =
            fun(int: Int, str: String): String {
                return ""
            }
        val resultAnonimFunDynamicType = fun(int: Int, str: String): String {
            return ""
        }
        val testResult1 = resultAnonimFunDynamicType // передали как ссылку на функцию
        val testResult2 = resultAnonimFunDynamicType(1, "") // выполнили и сохранили результат
        val resultLambda1: (int: Int, str: String) -> String = link@{ int: Int, str: String ->
            return@link ""
        }
        val resultLambda2: (int: Int, str: String) -> String = { _: Int, _: String -> "" }
        val resultLambda3: (int: Int, str: String) -> String = { _, _ -> "" }
        return resultAnonimFunStaticType
        return resultAnonimFunDynamicType
        return resultLambda1
        return resultLambda2
        return resultLambda3
    }

}


class Lesson4 {
    fun sayHiToLessonN(speakable: Speakable) {
        speakable.say("Привет из 4 урока")
    }
}

class Lesson1 : Speakable {
    override fun say(string: String) {
    }
}

class Lesson2 : Speakable {
    override fun say(string: String) {
    }
}

class Lesson3 : Speakable {
    override fun say(string: String) {
    }
}
