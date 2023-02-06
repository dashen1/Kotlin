package com.example.kotlinlearning.modules.login.inter

import android.content.Context
import com.example.kotlinlearning.base.IBasePresenter
import com.example.kotlinlearning.entity.LoginRegisterResponse

interface ILoginPresenter : IBasePresenter{

    fun loginAction(context: Context, username: String, password: String)

    interface onLoginListener{
        fun loginSuccess(loginRegisterBean: LoginRegisterResponse?)

        fun loginFailure(errMsg: String?)
    }
}