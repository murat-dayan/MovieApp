package com.example.movieapp.presentation.screens.series

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieapp.presentation.components.LoadingItem
import com.example.movieapp.presentation.components.SeriesItem
import com.example.movieapp.presentation.navigation.Screen

@Composable
fun SeriesScreen(
    modifier: Modifier,
    //serieState: SerieState,
    navController: NavController
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        )
    {
        /*if (serieState.series?.isNotEmpty()!!){
            Surface (
                color = MaterialTheme.colorScheme.outline
            ){
                LazyVerticalGrid (
                    modifier = Modifier.background(MaterialTheme.colorScheme.outline),
                    columns = GridCells.Fixed(2),
                    content = {
                        items(serieState.series){serie->
                            SeriesItem(
                                imageUrl = serie.posterPath ,
                                seriesTitle = serie.name,
                                seriesRate = serie.voteAverage.toString()
                            )
                        }
                    }
                    )
            }
        }

        if (serieState.isLoading){
            LoadingItem()
        }

        if (!(serieState.errorMsg.isNullOrEmpty())){
            println(serieState.errorMsg)
            Text(
                text = serieState.errorMsg
            )
        }*/
        
    }
}