package com.example.kotlinlearning.modules.register.inter

import android.content.Context

interface RegisterModule {
    fun cancelRequest()

    // 加上接口回调 把data数据返回给p层
    fun register(context: Context, username: String, password: String, repassword: String, onLoginListener: RegisterPresenter.onRegisterListener)
}