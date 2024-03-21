package com.example.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.screens.MoviesScreen
import com.example.movieapp.presentation.viewmodel.MoviesViewModel

@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.MovieScreen.route
    ){
        composable(Screen.MovieScreen.route){
            val moviesViewModel = hiltViewModel<MoviesViewModel>()
            val movieState = moviesViewModel.movieState.collectAsStateWithLifecycle().value
            MoviesScreen(modifier = Modifier, movieState = movieState)
        }
    }
}
