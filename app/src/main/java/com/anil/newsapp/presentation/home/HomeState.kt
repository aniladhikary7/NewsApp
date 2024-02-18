package com.anil.newsapp.presentation.home

data class HomeState(
    val newsTicker: String = "",
    val isLoading: Boolean = false,
)