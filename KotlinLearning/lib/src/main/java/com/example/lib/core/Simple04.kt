package com.example.lib.core


val name4: String = "kotlin"
val age4: Int = 18
val sex4: Char = 'M'

fun func() {
    println("I am func.")
}
fun main() {
    // 链式调用 只要返回值是 this
    val len = name4.myApply() {

    }.myApply {

    }.length

    name4.myAlso {
        it.length
    }.myAlso {
        it.length
    }.myAlso {
        it.length
    }.length.toDouble()

    name4.myLet {
        it.length
    }
    name4.myLet2 {
        this.length
    }
/*    name4.myApply()
    age4.myApply()
    sex4.myApply()
    func().myApply()*/
}

fun <T> T.myApply(mm: () -> Unit): T {
    return this
}

fun <T> T.myAlso(mm: (T) -> Unit): T {
    mm(this)
    return this
}

// it == T == this == name
fun <T, R> T.myLet(mm: (T) -> R): R = mm(this)

// 不想用默认it 给T增加匿名的扩展函数， 并且此函数形参是T
fun <T, R> T.myLet2(mm: T.(T) -> R): R {
    return mm(this)
}