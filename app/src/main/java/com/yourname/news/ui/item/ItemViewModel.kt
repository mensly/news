package com.yourname.news.ui.item

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yourname.news.model.NewsItem

class ItemViewModel : ViewModel() {
    var item = MutableLiveData<NewsItem>()
}
