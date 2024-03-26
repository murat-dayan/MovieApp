package com.example.movieapp.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.presentation.components.FavoritesItem
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun ProfileScreen(
    modifier: Modifier
) {

    Column(
    modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,

    )
    {
        FavoritesItem(favoriteName = "Favorite Movies")
        FavoritesItem(favoriteName = "Favorite Series")
    }
}
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    MovieAppTheme {
        ProfileScreen(modifier = Modifier)
    }
}
