package com.example.movieapp.data.remote.repository

import com.example.movieapp.core.common.Resource
import com.example.movieapp.data.remote.api.MoviesApi
import com.example.movieapp.data.remote.mapper.toCastModel
import com.example.movieapp.data.remote.mapper.toMovie
import com.example.movieapp.data.remote.mapper.toMovieDetailModel
import com.example.movieapp.data.remote.mapper.toSearchModel
import com.example.movieapp.data.remote.mapper.toSerie
import com.example.movieapp.data.remote.mapper.toSerieDetailModel
import com.example.movieapp.domain.model.CastModel
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetailModel
import com.example.movieapp.domain.model.SearchModel
import com.example.movieapp.domain.model.Serie
import com.example.movieapp.domain.model.SerieDetailModel
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

    override fun searchMovie(searchQuery: String): Flow<Resource<List<SearchModel>>>  = flow{

        emit(Resource.Loading())

        val list = moviesApi.searchMovie(searchQuery).results

        println(list[0].name)

        val result = list.map {
            it.toSearchModel()
        }
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }

    override fun getMovieDetail(movie_Id: Int): Flow<Resource<MovieDetailModel>> = flow{

        emit(Resource.Loading())

        val result = moviesApi.getMovieDetail(movie_Id).toMovieDetailModel()

        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }

    override fun getSerieDetail(serie_Id: Int): Flow<Resource<SerieDetailModel>> = flow{

        emit(Resource.Loading())

        val result = moviesApi.getSerieDetail(serie_Id).toSerieDetailModel()

        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }

    override fun getSeriesCast(serie_Id: Int): Flow<Resource<List<CastModel>>> = flow{

        emit(Resource.Loading())

        val result = moviesApi.getSeriesCast(serie_Id).cast.map {castDto->
            castDto.toCastModel()
        }

        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }

    override fun getMoviesCast(movie_Id: Int): Flow<Resource<List<CastModel>>> = flow{

        emit(Resource.Loading())

        val result = moviesApi.getMoviesCast(movie_Id).cast.map {castDto->
            castDto.toCastModel()
        }

        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }


}