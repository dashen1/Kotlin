package com.example.marvelgallery.view.common

import android.app.Activity
import androidx.annotation.IdRes
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun Activity.bindToSwipeRefresh(@IdRes swipeRefreshLayoutId: Int): ReadWriteProperty<Any?, Boolean>
        = SwipeRefreshBinding(lazy {findViewById<SwipeRefreshLayout>(swipeRefreshLayoutId)})

private class SwipeRefreshBinding(lazyViewProvider: Lazy<SwipeRefreshLayout>) : ReadWriteProperty<Any?, Boolean> {

    val view by lazyViewProvider

    override fun getValue(thisRef: Any?, property: KProperty<*>) = view.isRefreshing

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
        view.isRefreshing = value
    }
}