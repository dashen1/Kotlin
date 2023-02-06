package com.example.kotlinlearning.api

import com.example.kotlinlearning.entity.LoginRegisterResponse
import com.example.kotlinlearning.entity.LoginRegisterResponseWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface WanAndroidAPI {

    /**
     * login API
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun loginAction(@Field("username") username: String,
              @Field("password") password: String)
    : Observable<LoginRegisterResponseWrapper<LoginRegisterResponse>> // return
    /**
     * register API
     */
    @POST("/user/register")
    @FormUrlEncoded
    fun registerAction(@Field("username") username: String,
                    @Field("password") password: String,
                    @Field("password") repassword: String)
            : Observable<LoginRegisterResponseWrapper<LoginRegisterResponse>> // return
}