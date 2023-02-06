package com.example.lib.core

fun main() {
    ktRun(false) {
        //耗时操作
        println("custom thread")
    }

    doCounts(9) {
        println("执行了一次 ：$it")
    }
}

// 自定义轮询器
fun doCounts(counts: Int, mm: (Int) -> Unit) {
    for (index in 0 until 9) { // index 0-8
        mm(index)
    }
}

// 自定义线程封装
fun ktRun(
    start: Boolean = true,
    name: String? = null,
    //可以写多个参数
    myRunAction: () -> Unit): Thread {

    // Thread() 是java的，所以前面用 object
    val thread = object : Thread() {
        override fun run() {
            super.run()
            myRunAction()
        }
    }
    name ?: "Kotlin"
    if (start) thread.start()
    return thread
}