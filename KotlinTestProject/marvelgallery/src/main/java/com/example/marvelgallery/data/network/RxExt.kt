package com.example.marvelgallery.data.network

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * subscribeOn and observeOn are used to switch thread
 * Schedulers.io() mainly used to time-consuming operation. For example,
 * reading and writing files, database operation and network interaction and so on.
 * AndroidSchedulers.mainThread() are used to switch to mainThread(or UIThread) for updating UI.
 */
fun <T> Single<T>.applySchedulers(): Single<T> = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.subscribeBy(
    onError: ((Throwable) -> Unit)? = null,
    onSuccess: (T) -> Unit
): Disposable = subscribe(onSuccess, { onError?.invoke(it) }) // onError?.invoke(it) 相当于 onError(it)

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}