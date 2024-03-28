package com.example.movieapp.presentation.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.core.common.Resource
import com.example.movieapp.domain.use_case.GetSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchUseCase: GetSearchUseCase
) : ViewModel(){

    private val _searchModelState = MutableStateFlow(SearchModelState())
    val searchModelState : StateFlow<SearchModelState>
        get() = _searchModelState



    /*fun searchMovie(searchQuery:String){
        getSearchUseCase(searchQuery).onEach {result->


            when(result){
                is Resource.Error -> {
                    _searchModelState.value = SearchModelState().copy(errorMsg = result.msg)
                }
                is Resource.Loading -> {
                    _searchModelState.value = SearchModelState().copy(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                   _searchModelState.value = SearchModelState().copy(
                       seriesOrMovies = result.data
                   )
                }
            }
        }.launchIn(viewModelScope)
    }*/

    fun searchMovie(searchQuery:String){
        getSearchUseCase(searchQuery).onEach {result->

            when(result){
                is Resource.Error -> {
                    _searchModelState.value = SearchModelState().copy(
                        errorMsg = result.msg
                    )
                }
                is Resource.Loading -> {
                    _searchModelState.value = SearchModelState().copy(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _searchModelState.value = SearchModelState(
                        seriesOrMovies = result.data
                    )
                }
            }
        }.launchIn(viewModelScope)
    }



}