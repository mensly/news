package com.yourname.news.ui.main

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.squareup.picasso.Picasso
import com.yourname.news.R
import com.yourname.news.model.NewsItem
import com.yourname.news.util.LiveDataAdapter

class NewsItemAdapter(
    lifecycleOwner: LifecycleOwner,
    data: LiveData<List<NewsItem>>,
    onClick: (NewsItem) -> Unit = { }
) :
    LiveDataAdapter<NewsItem>(
        lifecycleOwner,
        R.layout.cell_news_item, data, onClick
    ) {
    override fun display(itemView: View, item: NewsItem) {
        itemView.findViewById<TextView>(android.R.id.text1).text = item.title
        itemView.findViewById<TextView>(android.R.id.text2).text = item.pubDate
        Picasso.get().load(item.thumbnail)
            .into(itemView.findViewById<ImageView>(R.id.thumbnail))
    }
}
