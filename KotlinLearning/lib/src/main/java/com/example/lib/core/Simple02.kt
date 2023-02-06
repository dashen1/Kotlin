package com.example.lib.core

val name: String = "hello"
val age: Int = 18

fun common() {
    println("I am common method!")
}

fun main() {
    common().myRun {
        println("execute advanced fun.")
    }
}

// T.myRun() 添加扩展函数
// T.() 给T添加一个匿名函数
fun <T, R> T.myRun(m: T.() -> R): R {
    return m() // 调用匿名函数包含高阶函数
}

fun <T, R> T.myRun2(m: T.() -> R): R = m()