package com.example.movieapp.data.remote.dto

data class ResultDto<T>(
    val page: Int,
    val results: List<T>,
    val total_pages: Int,
    val total_results: Int
)