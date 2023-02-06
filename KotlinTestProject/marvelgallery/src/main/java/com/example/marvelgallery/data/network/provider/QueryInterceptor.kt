package com.example.marvelgallery.data.network.provider

import com.example.marvelgallery.BuildConfig
import okhttp3.Interceptor

fun makeAddRequiredQueryInterceptor() = Interceptor { chain ->

    val originalRequest = chain.request()

    val timeStamp = System.currentTimeMillis()

    val url = originalRequest.url().newBuilder()
        .addQueryParameter("apikey", BuildConfig.PUBLIC_KEY)
        .addQueryParameter("hash", calculatedMD5(timeStamp.toString() + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY))
        .addQueryParameter("ts", "$timeStamp")
        .build()

    val request = originalRequest
        .newBuilder()
        .url(url)
        .build()
    chain.proceed(request)
}