package com.yourname.news.ui.main

import android.view.View
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.yourname.news.model.NewsItem
import com.yourname.news.util.LiveDataAdapter

class NewsItemAdapter(lifecycleOwner: LifecycleOwner, data: LiveData<List<NewsItem>>) :
    LiveDataAdapter<NewsItem>(lifecycleOwner, android.R.layout.simple_list_item_2, data) {
    override fun display(itemView: View, item: NewsItem) {
        itemView.findViewById<TextView>(android.R.id.text1).text = item.title
        itemView.findViewById<TextView>(android.R.id.text2).text = item.pubDate
    }
}
