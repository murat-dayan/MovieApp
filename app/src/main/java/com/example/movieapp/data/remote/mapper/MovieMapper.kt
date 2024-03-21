package com.example.movieapp.data.remote.mapper

import com.example.movieapp.data.remote.dto.MovieDto
import com.example.movieapp.domain.model.Movie

fun MovieDto.toMovie():Movie{
    return Movie(
        id = id,
        title = title,
        adult=adult,
        backdropPath = backdrop_path,
        originalLanguage = original_language,
        overview = overview,
        releaseDate = release_date,
        voteAverage = vote_average,
        posterPath = poster_path
    )
}