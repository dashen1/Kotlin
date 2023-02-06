package com.example.kotlinlearning.modules.register.inter

import android.content.Context
import com.example.kotlinlearning.base.IBasePresenter
import com.example.kotlinlearning.entity.LoginRegisterResponse

interface RegisterPresenter : IBasePresenter{

    fun registerAction(context: Context, username: String, password: String, repassword: String)

    interface onRegisterListener{
        fun registerSuccess(loginRegisterBean: LoginRegisterResponse?)

        fun registerFailure(errMsg: String?)
    }
}