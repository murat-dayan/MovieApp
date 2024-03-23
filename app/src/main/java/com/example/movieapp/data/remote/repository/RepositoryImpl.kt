package com.example.movieapp.data.remote.repository

import com.example.movieapp.core.common.Resource
import com.example.movieapp.data.remote.api.MoviesApi
import com.example.movieapp.data.remote.dto.MovieDto
import com.example.movieapp.data.remote.dto.SeriesDto
import com.example.movieapp.data.remote.mapper.toMovie
import com.example.movieapp.data.remote.mapper.toSerie
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.Serie
import com.example.movieapp.domain.repository.Repository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ViewModelScoped
class RepositoryImpl @Inject constructor(
    private val moviesApi: MoviesApi
) : Repository {
    override fun getAllMovies(): Flow<Resource<List<Movie>>> =  flow{
        emit(Resource.Loading())

        val list = moviesApi.getAllMovies().results
        val result = list.map {
            it.toMovie()
        }
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
    }

    override fun getAllSeries(): Flow<Resource<List<Serie>>>  = flow{
        emit(Resource.Loading())

        val list = moviesApi.getAllSeries().results
        val result = list.map {
            it.toSerie()
        }
        emit(Resource.Success(result))

    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }
}