package com.yourname.news.services

import com.yourname.news.model.NewsItem
import kotlinx.coroutines.delay

class NewsRepository {
    suspend fun getNews(): List<NewsItem> {
        delay(1000)
        return listOf(
            NewsItem(
                "42", "Half Life 3 confirmed for release on 5/11/2021",
                "30/03/2021"
            ),
            NewsItem(
                "45", "DOOM port released for Google Glass",
                "30/03/2021"
            ),
        )
    }
}
