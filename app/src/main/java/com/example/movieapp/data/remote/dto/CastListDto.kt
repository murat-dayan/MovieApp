package com.example.movieapp.data.remote.dto

data class CastListDto(
    val cast: List<CastDto>,
    val crew: List<CrewDto>,
    val id: Int
)