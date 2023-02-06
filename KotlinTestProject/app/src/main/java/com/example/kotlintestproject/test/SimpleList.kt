package com.example.kotlintestproject.test

class SimpleList<T> {

    private val list = mutableListOf<T>()
    fun add(item: T) {
        list.add(item)
    }

    fun get(index: Int): T {
        return list[index]
    }
}