package com.example.movieapp.domain.model


data class SerieDetailModel(
    val id: Int,
    val backdropPath: String?,
    val genres: List<GenreModel>,
    val name: String,
    val numberOfEpisodes: Int,
    val numberOfSeasons: Int,
    val overview: String,
    val status: String,
    val voteAverage: Double,
    val originalName: String,
)
