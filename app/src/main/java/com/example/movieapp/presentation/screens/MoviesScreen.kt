package com.example.movieapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp.core.utils.Constants
import com.example.movieapp.presentation.components.LoadingItem
import com.example.movieapp.presentation.state.MovieState

@Composable
fun MoviesScreen(
    modifier: Modifier,
    movieState: MovieState
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        if (movieState.movies?.isNotEmpty()!!){
            Text(text = movieState.movies[0].posterPath)
            AsyncImage(
                model = Constants.IMAGE_URL + movieState.movies[0].posterPath ,
                contentDescription ="",
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clip(CircleShape),
                contentScale = ContentScale.Fit

            )
        }

        if (movieState.isLoading){
            LoadingItem()
        }

        if (!(movieState.errorMsg.isNullOrEmpty())){
            println(movieState.errorMsg)
            Text(
                text = movieState.errorMsg
            )
        }
    }
}