package com.example.movieapp.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val adult: Boolean,
    val backdropPath: String,
    val originalLanguage: String,
    val overview: String,
    val releaseDate: String,
    val voteAverage: Double,
)
