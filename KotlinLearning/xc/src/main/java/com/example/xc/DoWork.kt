package com.example.xc

import android.os.Handler
import android.os.Looper
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request

private val mOKHttpClient: OkHttpClient = OkHttpClient()
private val mRequest = Request.Builder().url("https://baidu.com").get().build()

// 不使用协程 传统方式
fun displayMethod(textView: TextView) {
    val handler = Handler(Looper.getMainLooper()) {
        textView.text = it.obj as String
        false
    }

    object: Thread() {
        override fun run() {
            super.run()

            val result = mOKHttpClient.newCall(mRequest).execute().body()?.string()
            val msg = handler.obtainMessage()
            msg.obj = result
            handler.sendMessage(msg)
        }
    }.start()
}

fun displayMethodOk(textView: TextView) = runBlocking {
    launch {
        // 此时还是main线程
        // Dispatchers.IO 才是异步线程
        val def = async(Dispatchers.IO) {
            "string"
            mOKHttpClient.newCall(mRequest).execute().body()?.string()
        }
        // async(Dispatchers.IO)可以拿到异步线程的结果
        textView.text = def.await()
    }
}

fun displayMethodOkSimplest(textView: TextView) = runBlocking {
    launch {
        textView.text = async(Dispatchers.IO) {
            mOKHttpClient.newCall(mRequest).execute().body()?.string()
        }.await()
    }
}