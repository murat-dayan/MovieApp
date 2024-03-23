package com.example.movieapp.presentation.screens.series

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
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
            Text(text = serieState.series[1].name)
            
            Button(onClick = { 
                navController.navigate(Screen.SeriesDetailScreen.route)
            }) {
                Text(text = "Detaya git")
            }
        }*/
        
    }
}