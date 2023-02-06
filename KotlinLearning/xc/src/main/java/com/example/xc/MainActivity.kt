package com.example.xc

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click1(view: View) = runBlocking {  // 外协程
        // 默认是main线程
        // Dispatchers.IO main线程变成异步线程
        launch(Dispatchers.IO) { // 内协程
            Log.e("click1", "launch: ${Thread.currentThread().name}")

            repeat(10) {
                Thread.sleep(1000)
                Log.e("click1", "count: $it")
            }
        }
    }

    fun click2(view: TextView) = runBlocking {
//        displayMethod(view as TextView)
        displayMethodOk(view)
    }

    //runBlocking 阻塞式操作 必须走完流程才能作其他事情
    fun click3(view: View) = runBlocking {
        //1.注册耗时操作
        //2.注册完成后更新UI
        //3.登录耗时操作
        //4.登录完成后更新UI
        launch {
            withContext(Dispatchers.IO) {
                //1.注册耗时操作
                Log.d("click", "1.注册耗时操作: ${Thread.currentThread().name}")
                Thread.sleep(2000)
            }
            Log.d("click", "2.注册完成后更新UI: ${Thread.currentThread().name}")

            withContext(Dispatchers.IO) {
                //3.登录耗时操作
                Log.d("click", "3.登录耗时操作: ${Thread.currentThread().name}")
                Thread.sleep(3000)
            }

            Log.d("click", "4.登录完成后更新UI: ${Thread.currentThread().name}")
        }
    }

    //非阻塞 GlobalScope
    fun click4(view: View) = runBlocking {
        //1.注册耗时操作
        //2.注册完成后更新UI
        //3.登录耗时操作
        //4.登录完成后更新UI
        //main线程
        GlobalScope.launch(Dispatchers.Main) {
            val progressDialog = ProgressDialog(this@MainActivity)
            progressDialog.setMessage("正在执行中")
            progressDialog.show()

            withContext(Dispatchers.IO) {
                //1.注册耗时操作
                Log.d("click", "1.注册耗时操作: ${Thread.currentThread().name}")
                Thread.sleep(2000)
            }
            Log.d("click", "2.注册完成后更新UI: ${Thread.currentThread().name}")
            textView.text = "注册成功，可以登录了"
            progressDialog.setMessage(textView.text.toString())

            withContext(Dispatchers.IO) {
                //3.登录耗时操作
                Log.d("click", "3.登录耗时操作: ${Thread.currentThread().name}")
                Thread.sleep(3000)
            }

            Log.d("click", "4.登录完成后更新UI: ${Thread.currentThread().name}")
            textView.text = "登录成功"
            progressDialog.setMessage(textView.text.toString())

            progressDialog.dismiss()
        }
    }
}