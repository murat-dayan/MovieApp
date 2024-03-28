package com.example.movieapp.domain.model

data class SearchModel(
    val id: Int,
    val mediaType: String?,
    val name: String?,
    val posterPath:String?,
    val title:String?,
    val backdropPath:String?
)
