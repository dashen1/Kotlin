package com.example.kotlinlearning.modules.register

import android.content.Context
import android.util.Log
import com.example.kotlinlearning.api.WanAndroidAPI
import com.example.kotlinlearning.entity.LoginRegisterResponse
import com.example.kotlinlearning.modules.register.inter.RegisterModule
import com.example.kotlinlearning.modules.register.inter.RegisterPresenter
import com.example.kotlinlearning.net.APIClient
import com.example.kotlinlearning.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RegisterModelImpl : RegisterModule {
    override fun cancelRequest() {
        TODO("Not yet implemented")
    }

    override fun register(
        context: Context,
        username: String,
        password: String,
        repassword: String,
        onRegisterListener: RegisterPresenter.onRegisterListener
    ) {
        APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
            .registerAction(username, password, repassword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: APIResponse<LoginRegisterResponse>(context){
                override fun success(data: LoginRegisterResponse?) {
                    Log.d("TAG", "success:$data")
                    onRegisterListener.registerSuccess(data)
                }

                override fun failure(errMsg: String?) {
                    Log.d("TAG", "failure:$errMsg")
                    onRegisterListener.registerFailure(errMsg)
                }
            })
    }

}