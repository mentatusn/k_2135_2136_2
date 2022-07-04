package com.gb.k_2135_2136_2.lesson4

class Delegate {
}

fun main(){
    val worker1 = Worker1()
    val worker2 = Worker2()
    val lazyMan = LazyMan(worker1,worker2)
    lazyMan.work1()// выполнится worker1.work1()
    lazyMan.work2()// выполнится worker2.work2()
}

class LazyMan(worker1: Worker1,worker2: Worker2) : Workable1 by worker1,Workable2 by worker2{

}

interface Workable1 {
    fun work1()
}

interface Workable2 {
    fun work2()
}

class Worker1 : Workable1 {
    override fun work1() {
    }
}

class Worker2 : Workable2 {
    override fun work2() {
    }
}