package com.example.kotlinlearning.data_model.local.request

import android.os.Handler
import android.os.Looper
import android.os.Message
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

// 默认是final 类，变成abstract用于被继承
abstract class NetworkRequestData : Callback {
    override fun onFailure(call: Call, e: IOException) {
        requestError("Okhttp callback error!")
        Handler(Looper.getMainLooper(), object : Handler.Callback {
            override fun handleMessage(msg: Message): Boolean {
                // 如果message 不为null,就执行.let{}方法 it == message本身
//                e.message?.let { requestError(it)
                e.message?.myLet {
                    requestError(this)
                }
                return false
            }
        }).sendEmptyMessage(0)
    }

    override fun onResponse(call: Call, response: Response) {
        Handler(Looper.getMainLooper(), Handler.Callback {
            requestSuccess(response)
            false
        }).sendEmptyMessage(0)
    }

    abstract fun requestError(info: String)

    abstract fun requestSuccess(result: Response)
}

fun <T, R> T.myLet(mm: T.(T) -> R): R {
    return mm(this)
}