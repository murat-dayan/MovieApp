package com.example.movieapp.data.remote.repository

import com.example.movieapp.core.common.Resource
import com.example.movieapp.data.remote.api.MoviesApi
import com.example.movieapp.data.remote.mapper.toMovie
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.repository.Repository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@ViewModelScoped
class RepositoryImpl(
    private val moviesApi: MoviesApi
) : Repository {
    override fun getAllMovies(): Flow<Resource<List<Movie>>> =  flow{
        emit(Resource.Loading())

        val result = moviesApi.getAllMovies().map {
            it.toMovie()
        }
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }
}