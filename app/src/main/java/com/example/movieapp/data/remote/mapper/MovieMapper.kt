package com.example.movieapp.data.remote.mapper

import com.example.movieapp.data.remote.dto.MovieDto
import com.example.movieapp.data.remote.dto.SearchModelDto
import com.example.movieapp.data.remote.dto.SeriesDto
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.SearchModel
import com.example.movieapp.domain.model.Serie

fun MovieDto.toMovie():Movie{
    return Movie(
        id = id,
        title = title,
        adult=adult,
        originalLanguage = original_language,
        overview = overview,
        releaseDate = release_date,
        voteAverage = vote_average,
        posterPath = poster_path
    )
}

fun SeriesDto.toSerie():Serie{
    return Serie(
        backdropPath = backdrop_path,
        firstAirDate = first_air_date,
        id = id,
        name = name,
        overview = overview,
        posterPath = poster_path,
        voteAverage = vote_average
    )
}

fun SearchModelDto.toSearchModel():SearchModel{
    return SearchModel(
        id = id,
        name = name,
        mediaType = media_type,
        posterPath = poster_path,
        title = title,
        backdropPath = backdrop_path
    )
}
