package com.example.kotlinlearning.data_model.local

import com.example.kotlinlearning.database.Student

interface IDatabaseRequest {

    fun requestInert(vararg student: Student)
    fun requestUpdate(vararg student: Student)
    fun requestDelete(vararg student: Student)
    fun requestDeleteAll()
    fun requestQueryAll() : List<Student>?
}