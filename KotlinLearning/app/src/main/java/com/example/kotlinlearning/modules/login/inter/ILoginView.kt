package com.example.kotlinlearning.modules.login.inter

import com.example.kotlinlearning.entity.LoginRegisterResponse

interface ILoginView {

    fun loginSuccess(loginRegisterBean: LoginRegisterResponse?)

    fun loginFailure(errMsg: String?)
}