package com.example.kotlinlearning.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseFragment<P> : Fragment() where P: IBasePresenter{

    lateinit var p: P
    private lateinit var mActivity: AppCompatActivity // fragment 需要拿到activity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        p = getPresenter()
    }

    // 具体细节交由子类实现 将共用都放到base

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createFragment()
    }

    abstract fun getPresenter(): P

    abstract fun createFragment()
    abstract fun recycle()

    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }

    /**
     * 暴露给自己的孩子 隐藏ActionBar
     */
    fun hideActionBar() : Unit {
        val actionBar: ActionBar? = mActivity?.supportActionBar
        actionBar?.hide();
    }

    /**
     * 暴露给自己的孩子 显示ActionBar
     */
    fun showActionBar() : Unit {
        mActivity?.supportActionBar?.show()
    }

}