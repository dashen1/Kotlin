package com.example.lib.kt.s03

class Student (val id: Int, val name: String, val sex: Char){

    // component 不能写错， 函数名要一样

    operator fun component1(): Int = id

    operator fun component2(): String = name

    operator fun component3(): Char = sex

    operator fun component4(): String = "KT Study"
}

fun main() {
    val stu = Student(123, "java", 'M')

    val(n1, n2, n3, n4) = stu
    println(n1)
    println(n2)
    println(n3)
    println(n4)
}