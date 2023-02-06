package com.example.marvelgallery.view.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class RecyclerListAdapter(
        var items: List<AnyItemAdapter> = listOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount() = items.size

    override final fun getItemViewType(position: Int) = items[position].layoutId

    override final fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return items.first{ it.layoutId == layoutId }.onCreateViewHolder(itemView)
    }

    override final fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        items[position].bindViewHolder(holder)
    }
}

typealias AnyItemAdapter = ItemAdapter<out RecyclerView.ViewHolder>