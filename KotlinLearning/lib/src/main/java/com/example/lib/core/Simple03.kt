package com.example.lib.core

fun main() {

    // 以最后一行返回值为准
    val count = sum(1, 2, 3) { n1, n2, n3 ->
        println("sum: ${n1+n2+n3}")
        "ok"
        33.56
    }
    println("count: $count")
}


fun <R> sum(n1: Int, n2: Int, n3: Int, mm: (Int, Int, Int) -> R): R {
    return mm(n1, n2, n3)
}