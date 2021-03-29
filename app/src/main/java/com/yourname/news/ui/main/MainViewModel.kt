package com.yourname.news.ui.main

import androidx.lifecycle.ViewModel
import com.yourname.news.model.NewsItem

class MainViewModel : ViewModel() {
    var item = NewsItem("42", "Half Life 3 confirmed for release on 5/11/2021")
}
