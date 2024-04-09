package com.example.movieapp.presentation.screens.series_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.core.common.Resource
import com.example.movieapp.domain.use_case.GetMovieDetailUseCase
import com.example.movieapp.domain.use_case.GetSerieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SeriesDetailViewModel @Inject constructor(
    private val getSerieDetailUseCase: GetSerieDetailUseCase
) : ViewModel() {

    private val _serieDetailState = MutableStateFlow(SerieDetailState())
    val serieDetailState : StateFlow<SerieDetailState>
        get() = _serieDetailState




    fun getSerieDetail(serie_Id:Int){

        getSerieDetailUseCase(serie_Id).onEach {result->

            when(result){
                is Resource.Error -> {
                    _serieDetailState.value = SerieDetailState().copy(
                        errorMsg = result.msg
                    )
                }
                is Resource.Loading -> {
                    _serieDetailState.value = SerieDetailState().copy(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _serieDetailState.value = SerieDetailState().copy(
                        serieDetailModel = result.data
                    )
                }
            }
        }.launchIn(viewModelScope)

    }


}