package com.yourname.news.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yourname.news.model.NewsItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val items = MutableLiveData<List<NewsItem>>()
    init {
        viewModelScope.launch {
            delay(1000)
            items.value = listOf(
                NewsItem("42", "Half Life 3 confirmed for release on 5/11/2021", "30/03/2021"),
                NewsItem("45", "DOOM port released for Google Glass", "30/03/2021"),
            )
        }
    }
}
