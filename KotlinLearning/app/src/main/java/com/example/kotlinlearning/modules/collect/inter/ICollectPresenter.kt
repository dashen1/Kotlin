package com.example.kotlinlearning.modules.collect.inter

import android.content.Context
import com.example.kotlinlearning.base.IBasePresenter
import com.example.kotlinlearning.database.Student
import com.example.kotlinlearning.entity.LoginRegisterResponse

interface ICollectPresenter : IBasePresenter{

    fun requestInert(vararg student: Student)
    fun requestUpdate(vararg student: Student)
    fun requestDelete(vararg student: Student)
    fun requestDeleteAll()
    fun requestQueryAll()

    interface OnCollectResponseListener {
        fun showResultSuccess(result: List<Student> ?)
    }

    interface OnCollectListener {
        fun showIUD(iudResult: Boolean)
    }
}