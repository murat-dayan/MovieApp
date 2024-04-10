package com.example.movieapp.domain.use_case

import com.example.movieapp.domain.repository.Repository
import javax.inject.Inject

class GetMoviesCastUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun  invoke(movie_Id:Int) = repository.getMoviesCast(movie_Id)
}