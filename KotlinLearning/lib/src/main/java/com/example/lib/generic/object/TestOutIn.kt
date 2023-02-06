package com.example.lib.generic

import com.example.lib.generic.`object`.FuClass
import com.example.lib.generic.`object`.ZiClass

val fuClass = FuClass()

val ziClass = ZiClass()

fun test01() {

    // out 只能取，不能修改 ? extends === out
    // 将泛型作为内部方法返回 fun mm(): FuClass
    val list: MutableList<out FuClass> = ArrayList<ZiClass>()
    // in 只能修改，不能获取 ？ super === in
    // 将泛型作为内部方法的参数传值 fun mm(ZiClass)
    val list2: MutableList<in ZiClass> = ArrayList<FuClass>()
    list2.add(ziClass)
}