package com.example.movieapp.domain.model


data class MovieDetailModel(
    val id: Int,
    val backdropPath: String,
    val genres: List<GenreModel>,
    val originalTitle: String,
    val overview: String,
    val releaseDate: String,
    val voteAverage: Double,
    val runtime: Int,
)
