package com.example.kotlinlearning.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView

// 自定义view 一般加上注解
//@JvmOverloads 在有默认参数值的方法中使用该注解，kotlin就会暴露多个重载方法
class CustomListView @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int) :
    ListView(context, attrs, defStyleAttr)
{
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // 测量高度 java
        // int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST)
        // kotlin
        val expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE.shr(2), MeasureSpec.AT_MOST)
        super.onMeasure(widthMeasureSpec, expandSpec)
    }
}