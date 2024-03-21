package com.example.movieapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.movieapp.presentation.state.MovieState

@Composable
fun MoviesScreen(
    modifier: Modifier,
    movieState: MovieState
){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (movieState.movies?.isNotEmpty()!!){
            Text(
                text = movieState.movies[0].title
            )
        }
    }
}