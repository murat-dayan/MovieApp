package com.example.movieapp.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.screens.movies.MoviesScreen
import com.example.movieapp.presentation.screens.profile.ProfileScreen
import com.example.movieapp.presentation.screens.search.SearchScreen
import com.example.movieapp.presentation.screens.series.SeriesScreen
import com.example.movieapp.presentation.screens.movies.MoviesViewModel
import com.example.movieapp.presentation.screens.series.SeriesViewModel
import com.example.movieapp.presentation.screens.series_detail.SeriesDetailScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {

            NavigationBar(
                containerColor = Color.White
            ) {

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                listOfNavItems.onEach { navItem ->
                    NavigationBarItem(

                        selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                        onClick = {
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = navItem.icon),
                                contentDescription = null,
                                tint = if
                                               (currentDestination?.hierarchy?.any {
                                        it.route == navItem.route
                                    } == true)
                                    MaterialTheme.colorScheme.primary else Color.Black
                            )
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        },

    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.MovieScreen.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.MovieScreen.route) {
                /*val moviesViewModel = hiltViewModel<MoviesViewModel>()
                val movieState = moviesViewModel.movieState.collectAsStateWithLifecycle().value*/
                MoviesScreen(modifier = Modifier )
            }
            composable(Screen.SeriesScreen.route) {
                /*val seriesViewModel = hiltViewModel<SeriesViewModel>()
                val serieState = seriesViewModel.serieState.collectAsStateWithLifecycle().value*/
                SeriesScreen(
                    modifier = Modifier,navController = navController,)
            }
            composable(Screen.SearchScreen.route) {
                SearchScreen(modifier = Modifier)
            }
            composable(Screen.ProfileScreen.route) {
                ProfileScreen(modifier = Modifier)
            }
            composable(Screen.SeriesDetailScreen.route) {
                SeriesDetailScreen(modifier = Modifier)
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    Navigation()
}*/
