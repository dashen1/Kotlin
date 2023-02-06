package com.example.kotlinlearning.modules.collect.inter

import android.content.Context
import com.example.kotlinlearning.database.Student

interface ICollectModule {

    fun requestInsert(listener: ICollectPresenter.OnCollectListener, vararg students: Student)
    fun requestUpdate(listener: ICollectPresenter.OnCollectListener, vararg students: Student)
    fun requestDelete(listener: ICollectPresenter.OnCollectListener, vararg students: Student)
    fun requestDeleteAll(listener: ICollectPresenter.OnCollectListener)

    fun requestQueryAll(listener: ICollectPresenter.OnCollectResponseListener)
}