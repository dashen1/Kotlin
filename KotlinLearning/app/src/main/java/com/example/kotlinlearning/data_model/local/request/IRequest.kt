package com.example.kotlinlearning.data_model.local.request

import android.net.NetworkRequest

interface IRequest {

//    fun instanceRequestAction(url: String, resultData: NetworkRequestData)

    fun instanceRequestAction(url: String, value1: String, resultData: NetworkRequestData)

//    fun instanceRequestAction(url: String, value1: String, value2: String, value3: String, resultData: NetworkRequestData)

//    fun instanceRequestAction(url: String, resultData: NetworkRequestData, parameter: Map<String, String>)
}