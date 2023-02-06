package com.example.lib.core

fun main() {

    //() -> Unit 空参函数 没有返回值
    var method01: () -> Unit
//    method01() // 没有实现不能调用
//
//    var method02: (Int, Int) -> Int
//
//    var method03: (String, Int, Double) -> Any?
//
//    var method04: (Int, Double, Long, String?) -> Boolean

    var method05: (Int, Int) -> Int = {number1, number2 -> number1 + number2}
    println("method05:${method05(9,9)}")

    // (形参类型)
    // {具体详情}
    var method06 = {number1: Int, number2: Int -> number1 + number2}
    println("method06:${method06(4, 5)}")

    var method07 = {number1: Int, number2: Int -> number1.toDouble() + number2.toDouble()}
    println("method06:${method07(7, 5)}")

    var method08: (String, String) -> Unit = {str1, str2 -> println("method08:${str1 + str2}")}
    method08("hello", "world")

    var method09: (String) -> String = {str -> str}
    println("m09:${ method09("Kotlin")}")

    var method10: (Int) -> Unit = {
        when(it) {
            1 -> println("this is 1.")
            in 20..30 -> println("$it between 20 and 30")
            else -> println("other")
        }
    }
    method10(1)
    method10(22)

    var method11: (Int, Int, Int) -> Unit = { n1, n2, n3 ->
        println("n1:$n1, n2:$n2, n3: $n3")
    }
    method11(1, 2, 3)

    var method12 = { println("I am method 12")}
    method12()

    var method13 = {sex: Char ->
        if (sex == 'M') "represent boy"
        else "represent girls"
    }
    method13('M')

    //覆盖操作
    var method14 = {number: Int -> println("I am method14, my value is $number")}
    method14 = { println("overlap my value is $it")}
    method14(14)

    // 需求: 我想打印，还想有返回值，就是什么都可以
    var method15 = { number: Int -> println("I want to print $number")
        number + 100
    }

    println("method15: ${method15(33)}")

    fun method(n1: Int = 9, n2: Int = 100) {
        println("n1:$n1, n2:$n2")
    }

    // TODO -------- 高阶登录 --------------
    loginEngine("hello", "123456")

}

typealias RequestLogin = (String, String) -> Unit


// 函数做参数 (当函数参数是最后一个参数时，可以把实现放到括号外)
private fun loginService(userName: String, userPwd: String, requestLogin: (String, String) -> Unit) {
    requestLogin(userName, userPwd)
}

private fun loginService2(userName: String, userPwd: String, requestLogin: RequestLogin) {
    requestLogin(userName, userPwd)
}
fun loginEngine(userName: String, userPwd: String) : Unit{
    loginService(userName, userPwd){ name, pwd ->
        if (name == "hello" && pwd =="123456") {
            println("$name Login success")
        } else {
            println("login fail")
        }
    }
}