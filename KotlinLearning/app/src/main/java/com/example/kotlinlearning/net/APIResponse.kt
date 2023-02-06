package com.example.kotlinlearning.net

import android.content.Context
import com.example.kotlinlearning.LoadingDialog
import com.example.kotlinlearning.entity.LoginRegisterResponseWrapper
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

// 拦截 自定义操作符
abstract class APIResponse<T>(val context: Context): Observer<LoginRegisterResponseWrapper<T>>{

    private var isShowLoading: Boolean = true
    // 次构造
    constructor(context: Context, isShowLoading: Boolean = false): this(context) {

    }
    // success
    abstract fun success(data: T?)

    // failure
    abstract fun failure(errMsg: String?)

    override fun onSubscribe(d: Disposable) {

        if (isShowLoading) {
            LoadingDialog.show(context)
        }
    }

    override fun onNext(t: LoginRegisterResponseWrapper<T>) {
        if (t.data == null) {
            failure("Login failed! Please checking: msg:${t.errorMsg}")
        } else {

        }
    }

    override fun onError(e: Throwable) {
        LoadingDialog.cancel()
        failure(e.message)
    }

    override fun onComplete() {
        LoadingDialog.cancel()
    }
}