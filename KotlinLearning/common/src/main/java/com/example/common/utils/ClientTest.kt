package com.example.common.utils

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log

fun main() {
    Handler(Looper.getMainLooper(), object : Handler.Callback{
        override fun handleMessage(msg: Message): Boolean {
            //必须写东西 不然会崩溃
            return true
        }

    })

    Handler(Looper.getMainLooper(), Handler.Callback {
        true
    })

    Thread{
        Log.e("TAG", "main thread")
    }.start()
}