package com.example.marvelgallery.view.main

import android.os.Bundle
import android.view.Window
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelgallery.R
import com.example.marvelgallery.data.network.MarvelRepository
import com.example.marvelgallery.model.MarvelCharacter
import com.example.marvelgallery.presenter.MainPresenter
import com.example.marvelgallery.view.character.CharacterProfileActivity
import com.example.marvelgallery.view.common.BaseActivityWithPresenter
import com.example.marvelgallery.view.common.addOnTextChangedListener
import com.example.marvelgallery.view.common.bindToSwipeRefresh
import com.example.marvelgallery.view.common.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivityWithPresenter(), MainView {

    override var refresh by bindToSwipeRefresh(R.id.swipeRefreshView)

    override val presenter by lazy { MainPresenter(this, MarvelRepository.get()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        swipeRefreshView.setOnRefreshListener { presenter.onRefresh() }
        searchView.addOnTextChangedListener {
            onTextChanged { text, _, _, _ ->
                presenter.onSearchChanged(text)
            }
        }
        presenter.onViewCreated()
    }
    override fun show(items: List<MarvelCharacter>) {
        val categoryItemAdapters = items.map(this::createCategoryItemAdapter)
        recyclerView.adapter = MainListAdapter(categoryItemAdapters)
    }

    override fun showError(error: Throwable) {
        toast("Error: ${error.message}")
        error.printStackTrace()
    }

    private fun createCategoryItemAdapter(character: MarvelCharacter)
            = CharacterItemAdapter(character, {showHeroProfile(character)})

    private fun showHeroProfile(character: MarvelCharacter) {
        CharacterProfileActivity.start(this, character)
    }
}
