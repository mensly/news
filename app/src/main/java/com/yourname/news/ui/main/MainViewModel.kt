package com.yourname.news.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yourname.news.model.NewsItem
import com.yourname.news.services.NewsRepository
import kotlinx.coroutines.launch

class MainViewModel(newsRepository: NewsRepository) : ViewModel() {
    val items = MutableLiveData<List<NewsItem>>()
    init {
        viewModelScope.launch {
            items.value = newsRepository.getNews()
        }
    }
}
