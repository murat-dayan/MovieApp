package com.example.movieapp.domain.repository

import com.example.movieapp.core.common.Resource
import com.example.movieapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getAllMovies(): Flow<Resource<List<Movie>>>
}