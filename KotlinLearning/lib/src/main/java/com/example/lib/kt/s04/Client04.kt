package com.example.lib.kt.s04

import java.io.File

// 扩展函数
fun main() {
    val stu = Student04()
    stu.add(100, 200)

    val file = File("///")
    file.readText()

    file.show()
}

fun Student04.add(n1: Int, n2: Int) {
    println("result: ${n1+n2}")
}

fun Student04.show() {
    println("client04 show")
}

//给 file 增加扩展函数

fun File.show() {
    println("给 file 增加扩展函数")
}
