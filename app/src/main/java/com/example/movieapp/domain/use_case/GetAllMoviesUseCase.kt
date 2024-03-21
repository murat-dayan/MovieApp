package com.example.movieapp.domain.use_case

import com.example.movieapp.domain.repository.Repository

class GetAllMoviesUseCase(
    private val repository: Repository
) {

    operator fun invoke() = repository.getAllMovies()
}