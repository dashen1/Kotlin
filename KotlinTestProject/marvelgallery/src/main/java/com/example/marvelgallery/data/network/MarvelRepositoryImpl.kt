package com.example.marvelgallery.data.network

import com.example.marvelgallery.data.network.provider.retrofit
import com.example.marvelgallery.model.MarvelCharacter
import io.reactivex.Single

/**
 * Get a reference to a statically known kotlin class.
*/
class MarvelRepositoryImpl : MarvelRepository {
    val api = retrofit.create(MarvelApi::class.java)

    override fun getAllCharacters(searchQuery: String?): Single<List<MarvelCharacter>> =api.getCharacters(
        offset = 0,
        limit = elementsOnListLimit,
        searchQuery = searchQuery
    ).map {
        it.data?.results.orEmpty().map(::MarvelCharacter)
    }

    companion object {
        const val elementsOnListLimit = 50
    }
}