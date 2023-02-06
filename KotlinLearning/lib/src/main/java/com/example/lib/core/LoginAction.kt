package com.example.lib.core

fun main() {
    loginEngine("hello", "123456") {
        if (it) println("success") else println("fail")
    }

    val v = loginTest() {
        true
    }
}

public fun login(userName: String, userPwd: String, responseResult: (Boolean) -> Unit) {

}

private fun loginEngine(userName: String, userPwd: String, responseResult: (Boolean) -> Unit) {
    val DB_USER_NAME = "hello"
    val DB_USER_PWD = "123456"

    if (userName == DB_USER_NAME && userPwd == DB_USER_PWD) {
        responseResult(true)
    } else {
        responseResult(false)
    }
}

fun loginTest(m: () -> Boolean) : Int{
    val result = m()
    println("result: $result")
    return 888
}