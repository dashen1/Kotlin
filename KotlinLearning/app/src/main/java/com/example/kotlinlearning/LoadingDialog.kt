package com.example.kotlinlearning

import android.app.Dialog
import android.content.Context

// object 里面写的都是静态 没有主构造也没有次构造
object LoadingDialog {

    private var dialog: Dialog? = null
    // 内部生成的时候 根据INSTANCE 是伪静态
    fun show(context: Context){
        cancel()
        dialog = Dialog(context)
        dialog?.setContentView(R.layout.dialog_loading)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()
    }

    fun cancel() {
        dialog?.show()
    }

    @JvmStatic //这才是真正的静态
    fun show2(){

    }



}