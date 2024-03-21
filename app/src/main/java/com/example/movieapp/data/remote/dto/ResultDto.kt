package com.example.movieapp.data.remote.dto

data class ResultDto(
    val page: Int,
    val results: List<MovieDto>,
    val total_pages: Int,
    val total_results: Int
)