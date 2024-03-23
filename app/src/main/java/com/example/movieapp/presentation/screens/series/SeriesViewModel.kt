package com.example.movieapp.presentation.screens.series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.core.common.Resource
import com.example.movieapp.domain.use_case.GetAllSeriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val getAllSeriesUseCase: GetAllSeriesUseCase
) : ViewModel(){

    private val _serieState = MutableStateFlow(SerieState())
    val serieState : StateFlow<SerieState>
        get() = _serieState


    init {
        getAllSeries()
    }

    private fun getAllSeries(){

        getAllSeriesUseCase().onEach {result->

            when(result){
                is Resource.Error -> {
                    _serieState.value = SerieState().copy(errorMsg = result.msg)
                }
                is Resource.Loading -> {
                    _serieState.value = SerieState().copy(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _serieState.value = SerieState().copy(
                        series = result.data
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}