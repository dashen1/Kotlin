package com.example.kotlinlearning.entity

data class LoginRegisterResponseWrapper<T>(val data: T, val errorCode: Int, val errorMsg: String)