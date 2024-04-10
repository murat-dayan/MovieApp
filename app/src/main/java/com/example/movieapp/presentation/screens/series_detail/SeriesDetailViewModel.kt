package com.example.movieapp.presentation.screens.series_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.core.common.Resource
import com.example.movieapp.domain.use_case.GetMovieDetailUseCase
import com.example.movieapp.domain.use_case.GetSerieDetailUseCase
import com.example.movieapp.domain.use_case.GetSeriesCastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SeriesDetailViewModel @Inject constructor(
    private val getSerieDetailUseCase: GetSerieDetailUseCase,
    private val getSeriesCastUseCase: GetSeriesCastUseCase
) : ViewModel() {

    private val _serieDetailState = MutableStateFlow(SerieDetailState())
    val serieDetailState : StateFlow<SerieDetailState>
        get() = _serieDetailState


    private val _serieCastState = MutableStateFlow(SerieCastState())
    val serieCastState : StateFlow<SerieCastState>
        get() = _serieCastState




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

    fun getSerieCast(serie_Id:Int){

        getSeriesCastUseCase(serie_Id).onEach {result->

            when(result){
                is Resource.Error -> {
                    _serieCastState.value = SerieCastState().copy(
                        errorMsg = result.msg
                    )
                }
                is Resource.Loading -> {
                    _serieCastState.value = SerieCastState().copy(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _serieCastState.value = SerieCastState().copy(
                        castList = result.data
                    )
                }
            }
        }.launchIn(viewModelScope)

    }


}