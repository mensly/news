package com.yourname.news.model

import android.os.Parcelable
import androidx.core.text.HtmlCompat
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsItem(
    val id: String,
    val title: String,
    val pubDate: String,
    val thumbnail: String,
    val content: String,
    val link: String
) : Parcelable {
    val styledContent get() = HtmlCompat.fromHtml(content, 0)
}
