package com.example.movieapp.presentation.screens.series_detail

import com.example.movieapp.domain.model.CastModel
import com.example.movieapp.domain.model.SerieDetailModel

data class SerieCastState(
    val castList: List<CastModel>?= emptyList(),
    val isLoading: Boolean = false,
    val errorMsg:String?= ""
)
