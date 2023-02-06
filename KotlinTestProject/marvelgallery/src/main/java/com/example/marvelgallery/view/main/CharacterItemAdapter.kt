package com.example.marvelgallery.view.main

import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelgallery.R
import com.example.marvelgallery.model.MarvelCharacter
import com.example.marvelgallery.view.common.ItemAdapter
import com.example.marvelgallery.view.common.bindView
import com.example.marvelgallery.view.common.loadImage

class CharacterItemAdapter (
        val charater: MarvelCharacter,
        val clicked: (MarvelCharacter) -> Unit
        ): ItemAdapter<CharacterItemAdapter.ViewHolder>(R.layout.item_character) {

    override fun onCreateViewHolder(itemView: View) = ViewHolder(itemView)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView by bindView<TextView>(R.id.textView)
        val imageView by bindView<ImageView>(R.id.imageView)
    }

    override fun ViewHolder.onBindViewHolder() {
        itemView.setOnClickListener { clicked(charater) }
        textView.text = charater.name
        imageView.loadImage(charater.imageUrl)
    }

}