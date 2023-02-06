package com.example.kotlinlearning.modules.register.inter

import com.example.kotlinlearning.entity.LoginRegisterResponse

interface RegisterView {
    fun registerSuccess(loginRegisterBean: LoginRegisterResponse?)

    fun registerFailure(errMsg: String?)
}