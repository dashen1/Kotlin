package com.example.kotlinlearning.modules.register

import android.content.Context
import com.example.kotlinlearning.entity.LoginRegisterResponse
import com.example.kotlinlearning.modules.register.inter.RegisterPresenter
import com.example.kotlinlearning.modules.register.inter.RegisterView

class RegisterPresenterImpl(private var registerView: RegisterView?) : RegisterPresenter, RegisterPresenter.onRegisterListener{

    // 需要M层去请求服务器
    private var registerModel = RegisterModelImpl()
    // 需要View层更新UI

    override fun registerAction(context: Context, username: String, password: String, repassword: String) {
        // p层需要做很多校验工作
        registerModel.register(context, username, password, repassword, this)
    }

    override fun unAttachView() {
        registerView = null
        registerModel.cancelRequest()
    }

    override fun registerSuccess(loginRegisterBean: LoginRegisterResponse?) {
        registerView?.registerSuccess(loginRegisterBean)
    }

    override fun registerFailure(errMsg: String?) {
        registerView?.registerFailure(errMsg)
    }

    // 同时需要接受module层的结果


}