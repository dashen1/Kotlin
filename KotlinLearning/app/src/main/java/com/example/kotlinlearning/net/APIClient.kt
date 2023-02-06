package com.example.kotlinlearning.net

import com.example.kotlinlearning.api.WanAndroidAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIClient {

    private object Holder {
        val INSTANCE = APIClient()
    }

    // derives
    companion object {
        val instance = Holder.INSTANCE
    }

    // WanAndroidAPI initialize
    fun <T> instanceRetrofit(apiInterface: Class<T>) : T {

        // OKHTTPClient 请求服务器
        val mOKHttpClient = OkHttpClient().newBuilder()
            .myApply {
                readTimeout(10000, TimeUnit.SECONDS)
                connectTimeout(10000, TimeUnit.SECONDS)
                writeTimeout(10000, TimeUnit.SECONDS)
            }.build()

        // request
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")
            .client(mOKHttpClient)
        // response
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(apiInterface)
    }
}

fun <T> T.myApply(mm: T.() -> Unit): T {
    return this
}