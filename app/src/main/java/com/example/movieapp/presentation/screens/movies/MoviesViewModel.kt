package com.example.movieapp.presentation.screens.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.core.common.Resource
import com.example.movieapp.domain.use_case.GetAllMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
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
        }.launchIn(viewModelScope)
    }

}