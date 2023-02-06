package com.example.lib.generic.object2

//这个类，只能修改，不能获取
// 声明的时候加入泛型 in T
// java 不允许在声明泛型的时候
class Student<in T> {

    fun setData(data: T) {}

}