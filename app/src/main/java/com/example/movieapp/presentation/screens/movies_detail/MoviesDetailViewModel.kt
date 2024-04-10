package com.example.movieapp.presentation.screens.movies_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.core.common.Resource
import com.example.movieapp.domain.use_case.GetMovieDetailUseCase
import com.example.movieapp.domain.use_case.GetMoviesCastUseCase
import com.example.movieapp.presentation.screens.movies.MovieState
import com.example.movieapp.presentation.screens.series_detail.SerieCastState

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

import javax.inject.Inject
@HiltViewModel
class MoviesDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val getMoviesCastUseCase: GetMoviesCastUseCase
) : ViewModel() {

    private val _movieDetailState = MutableStateFlow(MovieDetailState())
    val movieDetailState : StateFlow<MovieDetailState>
        get() = _movieDetailState

    private val _movieCastState = MutableStateFlow(MovieCastState())
    val movieCastState : StateFlow<MovieCastState>
        get() = _movieCastState


    init {

    }


    fun getMovieDetail(movieId:Int){

        getMovieDetailUseCase(movieId).onEach { result->
            when(result){
                is Resource.Error -> {
                    _movieDetailState.value = MovieDetailState().copy(errorMsg = result.msg)
                }
                is Resource.Loading -> {
                    _movieDetailState.value = MovieDetailState().copy(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _movieDetailState.value = MovieDetailState().copy(
                        movieDetailModel = result.data
                    )
                }
            }
        }.launchIn(viewModelScope)

    }

    fun getMovieCast(movieId: Int){

        getMoviesCastUseCase(movieId).onEach {result->

            when(result){
                is Resource.Error -> {
                    _movieCastState.value = MovieCastState().copy(
                        errorMsg = result.msg
                    )
                }
                is Resource.Loading -> {
                    _movieCastState.value = MovieCastState().copy(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _movieCastState.value = MovieCastState().copy(
                        castList = result.data
                    )
                }
            }
        }.launchIn(viewModelScope)

    }





}