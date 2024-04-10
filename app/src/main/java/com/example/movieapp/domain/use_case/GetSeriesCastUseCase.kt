package com.example.movieapp.domain.use_case

import com.example.movieapp.domain.repository.Repository
import javax.inject.Inject

class GetSeriesCastUseCase  @Inject constructor(
    private val repository: Repository
) {

    operator fun  invoke(serieId:Int) = repository.getSeriesCast(serieId)
}