package com.example.movieapp.presentation.screens.search

import com.example.movieapp.domain.model.SearchModel
import com.example.movieapp.domain.model.Serie

data class SearchModelState (
    val seriesOrMovies: List<SearchModel>?= emptyList(),
    val isLoading: Boolean = false,
    val errorMsg:String?= ""
)