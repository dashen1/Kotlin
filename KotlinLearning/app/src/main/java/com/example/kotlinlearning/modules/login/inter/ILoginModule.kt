package com.example.kotlinlearning.modules.login.inter

import android.content.Context

interface ILoginModule {
    fun cancelRequest()

    // 加上接口回调 把data数据返回给p层
    fun login(context: Context, username: String, password: String, onILoginListener: ILoginPresenter.onLoginListener)
}