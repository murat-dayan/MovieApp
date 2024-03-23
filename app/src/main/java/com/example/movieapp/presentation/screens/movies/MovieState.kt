package com.example.movieapp.presentation.screens.movies

import com.example.movieapp.domain.model.Movie

data class MovieState(
    val movies: List<Movie>?= emptyList(),
    val isLoading: Boolean = false,
    val errorMsg:String?= ""
)
