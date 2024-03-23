package com.example.movieapp.presentation.screens.series

import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.Serie

data class SerieState(
    val series: List<Serie>?= emptyList(),
    val isLoading: Boolean = false,
    val errorMsg:String?= ""
)
