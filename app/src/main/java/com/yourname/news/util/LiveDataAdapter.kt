package com.yourname.news.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

abstract class LiveDataAdapter<T>(
    lifecycleOwner: LifecycleOwner,
    @LayoutRes val layout: Int,
    val data: LiveData<List<T>>,
    val onClickItem: (T) -> Unit = { }
) :
    RecyclerView.Adapter<LiveDataAdapter<T>.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { item?.let { onClickItem(it) } }
        }
        var item: T? by Delegates.observable(null) { _, _, newItem ->
            newItem?.let { display(itemView, it) }
        }
    }

    init {
        data.observe(lifecycleOwner) { notifyDataSetChanged() }
    }

    private val items get() = data.value ?: emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(layout, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item = items[position]
    }

    override fun getItemCount() = items.size

    abstract fun display(itemView: View, item: T)
}
