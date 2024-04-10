package com.example.movieapp.domain.model

data class CastModel(
    val character: String,
    val id: Int,
    val knownForDepartment: String,
    val name: String,
    val profilePath: String?
)
