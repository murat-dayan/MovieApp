package com.example.movieapp.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.movieapp.R

data class NavItem(
    val label:String,
    @DrawableRes val icon:Int,
    val route:String
)

val listOfNavItems : List<NavItem> = listOf(
    NavItem(
        label = "Movies",
        icon = R.drawable.ic_movie,
        route = Screen.MovieScreen.route
    ),
    NavItem(
        label = "Series",
        icon = R.drawable.ic_series,
        route = Screen.SeriesScreen.route
    ),
    NavItem(
        label = "Search",
        icon = R.drawable.ic_search,
        route = Screen.SearchScreen.route
    ),
    NavItem(
        label = "Profile",
        icon = R.drawable.ic_profile,
        route = Screen.ProfileScreen.route
    )
)
