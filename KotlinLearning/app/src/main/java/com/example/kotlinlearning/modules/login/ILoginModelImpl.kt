package com.example.kotlinlearning.modules.login

import android.content.Context
import android.util.Log
import com.example.kotlinlearning.api.WanAndroidAPI
import com.example.kotlinlearning.entity.LoginRegisterResponse
import com.example.kotlinlearning.modules.login.inter.ILoginModule
import com.example.kotlinlearning.modules.login.inter.ILoginPresenter
import com.example.kotlinlearning.net.APIClient
import com.example.kotlinlearning.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ILoginModelImpl : ILoginModule {
    override fun cancelRequest() {
        TODO("Not yet implemented")
    }

    override fun login(
        context: Context,
        username: String,
        password: String,
        onILoginListener: ILoginPresenter.onLoginListener
    ) {
        APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
            .loginAction(username, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: APIResponse<LoginRegisterResponse>(context){
                override fun success(data: LoginRegisterResponse?) {
                    Log.d("TAG", "success:$data")
                    onILoginListener.loginSuccess(data)
                }

                override fun failure(errMsg: String?) {
                    Log.d("TAG", "failure:$errMsg")
                    onILoginListener.loginFailure(errMsg)
                }
            })
    }

}