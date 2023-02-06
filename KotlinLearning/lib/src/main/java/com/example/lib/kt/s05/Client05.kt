package com.example.lib.kt.s05

fun main() {
    show(true) {
//        println(it)
        "OK"
    }
}

// loginMethod 方法名
// ()方法那个括号
// loginMethod:() ->Unit
// -> 方法体 做事情
// Unit == void
fun show(isLogin: Boolean, loginMethod:(Boolean) -> String) {
    if (isLogin) {
        println("login success")
        val v1 = loginMethod(true)
    } else {
        println("login fail")
        val v2 = loginMethod(false)
    }
}