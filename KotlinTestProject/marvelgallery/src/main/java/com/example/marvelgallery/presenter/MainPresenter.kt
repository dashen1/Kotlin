package com.example.marvelgallery.presenter

import com.example.marvelgallery.data.network.MarvelRepository
import com.example.marvelgallery.data.network.applySchedulers
import com.example.marvelgallery.data.network.plusAssign
import com.example.marvelgallery.data.network.subscribeBy
import com.example.marvelgallery.view.main.MainView

class MainPresenter(val view: MainView, val repository: MarvelRepository) : BasePresenter() {

    fun onViewCreated() {
        loadCharacters()
    }

    fun onRefresh() {
        loadCharacters()
    }

    fun onSearchChanged(newText: String) {
        loadCharacters(newText)
    }

    private fun loadCharacters(search: String? = null) {
        val qualifiedSearchQuery = if (search.isNullOrBlank()) null else search
        subscriptions += repository
            .getAllCharacters(qualifiedSearchQuery)
            .applySchedulers()
            .doOnSubscribe { view.refresh = true }
            .doFinally { view.refresh = false }
            .subscribeBy(
                onSuccess = view::show,
                onError = view::showError
            )
    }
}