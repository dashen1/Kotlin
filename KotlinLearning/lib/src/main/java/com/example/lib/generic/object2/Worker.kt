package com.example.lib.generic.object2

class Worker<out T> {
    fun getData(): T? = null

    // 不能修改
//    fun setData(data: T) {}
}