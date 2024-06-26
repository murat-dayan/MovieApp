package com.example.movieapp.domain.repository

import com.example.movieapp.core.common.Resource
import com.example.movieapp.domain.model.CastModel
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetailModel
import com.example.movieapp.domain.model.SearchModel
import com.example.movieapp.domain.model.Serie
import com.example.movieapp.domain.model.SerieDetailModel
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getAllMovies(): Flow<Resource<List<Movie>>>

    fun getAllSeries(): Flow<Resource<List<Serie>>>

    fun searchMovie(searchQuery:String): Flow<Resource<List<SearchModel>>>

    fun getMovieDetail(movie_Id:Int) : Flow<Resource<MovieDetailModel>>

    fun getSerieDetail(serie_Id:Int) : Flow<Resource<SerieDetailModel>>

    fun getSeriesCast(serie_Id: Int) : Flow<Resource<List<CastModel>>>

    fun getMoviesCast(movie_Id: Int) : Flow<Resource<List<CastModel>>>


}