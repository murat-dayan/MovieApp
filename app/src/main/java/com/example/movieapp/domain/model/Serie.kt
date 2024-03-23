package com.example.movieapp.domain.model

data class Serie(
    val backdropPath: String,
    val firstAirDate: String,
    val id: Int,
    val name: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double,
)
