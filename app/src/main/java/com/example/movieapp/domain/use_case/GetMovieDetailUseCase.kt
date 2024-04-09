package com.example.movieapp.domain.use_case

import com.example.movieapp.domain.repository.Repository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun  invoke(movieID:Int) = repository.getMovieDetail(movieID)
}