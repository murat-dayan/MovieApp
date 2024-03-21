package com.example.movieapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.movieapp.core.common.Resource
import com.example.movieapp.domain.use_case.GetAllMoviesUseCase
import com.example.movieapp.presentation.state.MovieState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach

class MoviesViewModel(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
) : ViewModel(){

    private val _movieState = MutableStateFlow(MovieState())
    val movieState : StateFlow<MovieState>
        get() = _movieState


    init {
        getAllMovies()
    }

    private fun getAllMovies(){

        getAllMoviesUseCase().onEach {result->

            when(result){
                is Resource.Error -> {
                    _movieState.value = MovieState().copy(errorMsg = result.msg)
                }
                is Resource.Loading -> {
                    _movieState.value = MovieState().copy(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _movieState.value = MovieState().copy(
                        movies = result.data
                    )
                }
            }
        }
    }

}