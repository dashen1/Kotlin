package com.example.lib.kt

import com.example.lib.java.s01.JavaStudent
import com.example.lib.java.callback.JavaCallback
import com.example.lib.java.callback.JavaManager
import com.example.lib.kt.callback.KTCallBack
import com.example.lib.kt.callback.KtManager
import com.example.lib.kt.s01.KtStudent
import kotlin.reflect.KClass

fun main(){

    //解决冲突问题 in在kotlin中是关键字
    println(JavaStudent.`in`)
    //String! 由于是！最好是 var str: String ? = 用变量接收 就不会引发空指针异常
    //JavaStudent().string.length是错误的
    var str: String? = JavaStudent().string
    println(str?.length)

    showClass(JavaStudent::class.java)

    showClass2(KtStudent::class)

    //kotlin 使用java callback
    //TODO kotlin
    //第一种写法
    JavaManager().setCallback {
        println(it)
    }
    //第二种写法
    JavaManager().setCallback { object : JavaCallback{
        override fun show(info: String?) {
            println(info)
        }
    }
    //第三种写法
    val callback = JavaCallback {
        println(it)
    }
        //第四种写法
        val callback2 = JavaCallback { info -> println(info) }

        // TODO kotlin 调用kotlin callback
        //第一种
        KtManager().setCallback(object : KTCallBack {
            override fun show(info: String) {
                fun show(info: String) {

                }
            }
        })
        //第二种
        val ktCallback = object : KTCallBack{
            override fun show(info: String) {

            }

        }
    }
}

// 形参是java
fun showClass(clazz: Class<JavaStudent>){

}

// 形参里面全部用kotlin
fun showClass2(clazz: KClass<KtStudent>) {

}