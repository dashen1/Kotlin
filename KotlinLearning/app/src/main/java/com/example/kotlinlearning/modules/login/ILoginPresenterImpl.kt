package com.example.kotlinlearning.modules.login

import android.content.Context
import com.example.kotlinlearning.entity.LoginRegisterResponse
import com.example.kotlinlearning.modules.login.inter.ILoginPresenter
import com.example.kotlinlearning.modules.login.inter.ILoginView

class ILoginPresenterImpl(private var ILoginView: ILoginView?) : ILoginPresenter, ILoginPresenter.onLoginListener{

    // 需要M层去请求服务器
    private var loginModel = ILoginModelImpl()
    // 需要View层更新UI

    override fun loginAction(context: Context, username: String, password: String) {
        // p层需要做很多校验工作
        loginModel.login(context, username, password, this)
    }

    override fun unAttachView() {
        ILoginView = null
        loginModel.cancelRequest()
    }

    override fun loginSuccess(loginRegisterBean: LoginRegisterResponse?) {
        ILoginView?.loginSuccess(loginRegisterBean)
    }

    override fun loginFailure(errMsg: String?) {
        ILoginView?.loginFailure(errMsg)
    }

    // 同时需要接受module层的结果


}