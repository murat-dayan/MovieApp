package com.example.movieapp.presentation.navigation

sealed class Screen(val route:String) {
    object MovieScreen : Screen("movie_screen")
    object SeriesScreen : Screen("series_screen")
    object SearchScreen : Screen("search_screen")
    object ProfileScreen : Screen("profile_screen")
    object SeriesDetailScreen : Screen("series_detail_screen")

    object FavoriteScreen: Screen("favorite_screen")
}