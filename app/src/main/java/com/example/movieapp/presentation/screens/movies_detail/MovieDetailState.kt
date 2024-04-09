package com.example.movieapp.presentation.screens.movies_detail

import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetailModel

data class MovieDetailState(
    val movieDetailModel: MovieDetailModel?=null,
    val isLoading: Boolean = false,
    val errorMsg:String?= ""
)