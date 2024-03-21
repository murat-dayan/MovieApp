package com.example.movieapp.presentation.navigation

sealed class Screen(val route:String) {
    object MovieScreen : Screen("movie_screen")
}