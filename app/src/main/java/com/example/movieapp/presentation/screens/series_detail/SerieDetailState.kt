package com.example.movieapp.presentation.screens.series_detail

import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetailModel
import com.example.movieapp.domain.model.SerieDetailModel

data class SerieDetailState(
    val serieDetailModel: SerieDetailModel?=null,
    val isLoading: Boolean = false,
    val errorMsg:String?= ""
)