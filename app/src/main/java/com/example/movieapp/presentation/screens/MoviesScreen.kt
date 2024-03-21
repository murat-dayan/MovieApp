package com.example.movieapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.movieapp.presentation.components.CardItem
import com.example.movieapp.presentation.components.LoadingItem
import com.example.movieapp.presentation.state.MovieState

@Composable
fun MoviesScreen(
    modifier: Modifier,
    //movieState: MovieState
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(text = "Movies")
        /*if (movieState.movies?.isNotEmpty()!!){
            Surface (
                color = MaterialTheme.colorScheme.outline
            ){
                LazyColumn (
                    modifier = Modifier.background(MaterialTheme.colorScheme.outline),

                    ){
                    items(movieState.movies){movie->
                        CardItem(
                            imageUrl = movie.posterPath ,
                            cardTitle = movie.title,
                            cardRate = movie.voteAverage.toString(),
                            cardDate = movie.releaseDate
                        )
                    }
                }
            }
        }

        if (movieState.isLoading){
            LoadingItem()
        }

        if (!(movieState.errorMsg.isNullOrEmpty())){
            println(movieState.errorMsg)
            Text(
                text = movieState.errorMsg
            )
        }*/
    }
}
























