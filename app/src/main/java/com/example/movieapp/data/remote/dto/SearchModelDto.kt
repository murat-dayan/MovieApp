package com.example.movieapp.data.remote.dto

data class SearchModelDto(
    val adult: Boolean?,
    val backdrop_path: String?,
    val id: Int,
    val title: String?,
    val name: String?,
    val original_language: String?,
    val original_title: String?,
    val original_name: String?,
    val overview: String?,
    val poster_path: String?,
    val genre_ids: List<Int>?,
    val popularity: Double?,
    val release_date: String?,
    val first_air_date: String?,
    val vote_average: Double?,
    val vote_count: Int?,
    val media_type: String?,
    val origin_country: List<String>?,
    val video: Boolean?,
    val gender: Int?,
    val known_for_department: String?,
    val profile_path: String?,
    val known_for: List<KnownFor>?

)