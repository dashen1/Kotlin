package com.example.marvelgallery.view.main

import com.example.marvelgallery.model.MarvelCharacter

interface MainView {
    var refresh: Boolean
    fun show(items: List<MarvelCharacter>)
    fun showError(error: Throwable)
}