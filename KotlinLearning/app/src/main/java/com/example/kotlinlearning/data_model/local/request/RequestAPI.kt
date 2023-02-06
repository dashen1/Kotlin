package com.example.kotlinlearning.data_model.local.request

import android.content.Context
import com.example.kotlinlearning.config.Flag
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request

object RequestAPI : IRequest{

//    companion object {
//        fun instanceRequestAPI(): IRequest = RequestAPI()
//
//        fun instanceRequestAPI(context: Context): IRequest = RequestAPI()
//    }

/*    override fun instanceRequestAction(url: String, resultData: NetworkRequestData) {
        commonOKHttpRequestAction(url, resultData)
    }*/

    override fun instanceRequestAction(
        url: String,
        value1: String,
        resultData: NetworkRequestData
    ) {
        commonOKHttpRequestAction(url, resultData, value1)
    }

/*    override fun instanceRequestAction(
        url: String,
        value1: String,
        value2: String,
        value3: String,
        resultData: NetworkRequestData
    ) {
        commonOKHttpRequestAction(url, resultData, value1, value2, value3)
    }*/

/*    override fun instanceRequestAction(
        url: String,
        resultData: NetworkRequestData,
        parameter: Map<String, String>
    ) {

    }*/

    private fun commonOKHttpRequestAction(url: String, resultData: NetworkRequestData, vararg values: String) {
        //1.创建一个okhttp对象
        val okhttpClient = OkHttpClient()

        //2.构建参数的body，Multipartbody.FORM
        val build: MultipartBody.Builder = MultipartBody.Builder().setType(MultipartBody.FORM)

        //参数根据可变参数 数量变化而变化
        for (value in values) {
            // 2.2 封装参数
            build.addFormDataPart(Flag.PART, value)
        }
        //3.构建一个请求, post 提交里面是参数的builder url()请求路径
        val request: Request = Request.Builder().url(url)
            .post(build.build()).build()
        //4.发送一个请求给服务器
        okhttpClient.newCall(request).enqueue(resultData)
    }
}