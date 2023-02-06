package com.example.xc

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// 挂起 函数 标记
suspend fun main() {
    val job = GlobalScope.launch {
        repeat(1000) {
            delay(40)
            println("1111111 $it")
        }
    }

    println("A")

    Thread.sleep(100)
//    job.cancel()    //还有一点点时间差，不是马上停止
    job.cancelAndJoin()      // 一点点时间差都不允许
}