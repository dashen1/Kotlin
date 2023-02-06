package com.example.kotlinlearning.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

// 没有abstract 默认是public final class
//where P: IBasePresenter, P: Serializable 等价于 p extend & Serializable
abstract class BaseActivity<P> : AppCompatActivity() where P: IBasePresenter{

    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        presenter = createP()
    }

    // 具体细节交由子类实现 将共用都放到base
    abstract fun createP(): P

    abstract fun recycle()

    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }

    fun hideActionBar() {
        // 任何java代码东西 必须用？ 允许为null 来接收
        val actionBar : ActionBar? = supportActionBar
        actionBar?.hide()
    }

    fun showActionBar() {
        // 任何java代码东西 必须用？ 允许为null 来接收
        supportActionBar?.show()
    }
}