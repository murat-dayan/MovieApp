package com.example.movieapp.data.remote.api

import com.example.movieapp.core.utils.Constants
import com.example.movieapp.data.remote.dto.MovieDto
import com.example.movieapp.data.remote.dto.ResultDto
import com.example.movieapp.data.remote.dto.SeriesDto
import retrofit2.http.GET

interface MoviesApi {

    @GET("discover/movie?api_key=${Constants.API_KEY}")
    suspend fun getAllMovies(): ResultDto<MovieDto>

    @GET("discover/tv?api_key=${Constants.API_KEY}")
    suspend fun getAllSeries(): ResultDto<SeriesDto>
}