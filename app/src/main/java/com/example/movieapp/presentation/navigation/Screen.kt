package com.example.movieapp.presentation.navigation

sealed class Screen(val route:String) {
    object MovieScreen : Screen("movie_screen")
    object SeriesScreen : Screen("series_screen")
    object SearchScreen : Screen("search_screen")
    object ProfileScreen : Screen("profile_screen")
    object SeriesDetailScreen : Screen("series_detail_screen/{id}"){
        fun createRoute(id:Int) = "series_detail_screen/$id"
    }

    object FavoriteScreen: Screen("favorite_screen")

    object MoviesDetailScreen: Screen("movies_detail_screen/{id}"){
        fun createRoute(id:Int) = "movies_detail_screen/$id"
    }
}