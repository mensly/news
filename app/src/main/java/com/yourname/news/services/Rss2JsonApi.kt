package com.yourname.news.services

import com.yourname.news.model.ListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Rss2JsonApi {
    @GET("api.json")
    suspend fun getFeed(@Query("rss_url") rssUrl: String): ListResponse
}
