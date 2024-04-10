package com.example.movieapp.data.remote.api

import com.example.movieapp.core.utils.Constants
import com.example.movieapp.data.remote.dto.CastListDto
import com.example.movieapp.data.remote.dto.MovieDetailDto
import com.example.movieapp.data.remote.dto.MovieDto
import com.example.movieapp.data.remote.dto.ResultDto
import com.example.movieapp.data.remote.dto.SearchModelDto
import com.example.movieapp.data.remote.dto.SerieDetailDto
import com.example.movieapp.data.remote.dto.SeriesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("discover/movie?api_key=${Constants.API_KEY}")
    suspend fun getAllMovies(): ResultDto<MovieDto>

    @GET("discover/tv?api_key=${Constants.API_KEY}")
    suspend fun getAllSeries(): ResultDto<SeriesDto>


    @GET("search/multi?api_key=${Constants.API_KEY}&include_adult=false&language=en-US&page=1")
    suspend fun searchMovie(@Query("query") searchQuery:String): ResultDto<SearchModelDto>

    @GET("https://api.themoviedb.org/3/movie/{movie_Id}?api_key=${Constants.API_KEY}")
    suspend fun getMovieDetail(@Path("movie_Id") movie_Id:Int) : MovieDetailDto

    @GET("https://api.themoviedb.org/3/tv/{serie_Id}?api_key=${Constants.API_KEY}")
    suspend fun getSerieDetail(@Path("serie_Id") serie_Id:Int): SerieDetailDto

    @GET("tv/{serie_Id}/credits?api_key=${Constants.API_KEY}")
    suspend fun getSeriesCast(@Path("serie_Id") serie_Id:Int) : CastListDto

    @GET("movie/{movie_Id}/credits?api_key=${Constants.API_KEY}")
    suspend fun getMoviesCast(@Path("movie_Id") movie_Id: Int) : CastListDto



}