package com.anil.newsapp.data.remote.dto

import com.anil.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)