package com.gb.k_2135_2136_2.lesson4


fun interface Speakable {
    fun say(string: String)
}

class Lesson4 {
    fun sayHiToLessonN(speakable:Speakable) {
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
