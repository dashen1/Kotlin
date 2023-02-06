package com.example.marvelgallery.view.common

import com.example.marvelgallery.presenter.Presenter

abstract class BaseActivityWithPresenter : BaseActivity() {
    abstract val presenter: Presenter

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}