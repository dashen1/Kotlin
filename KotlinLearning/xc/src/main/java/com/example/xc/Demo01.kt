package com.example.xc

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    //非阻塞，类似守护线程
    GlobalScope.launch {
        delay(1000)
        println("ssss")
    }
    println("A")
    //main线程
//    Thread.sleep(2000)
    Thread.sleep(200)

    println("B")
    //main 线程结束 此时 println("ssss")不会执行了
}