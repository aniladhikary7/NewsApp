package com.anil.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.anil.newsapp.data.remote.NewsApi
import com.anil.newsapp.data.remote.NewsPagingSource
import com.anil.newsapp.data.remote.SearchNewsPagingSource
import com.anil.newsapp.domain.model.Article
import com.anil.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(private val newsApi: NewsApi): NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsApi = newsApi, sources = sources.joinToString(separator = ","))
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    api = newsApi,
                    searchQuery = searchQuery,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }


}