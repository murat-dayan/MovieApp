package com.example.movieapp.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movieapp.presentation.components.FavoritesItem
import com.example.movieapp.presentation.components.TextItem
import com.example.movieapp.presentation.navigation.Screen
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun ProfileScreen(
    modifier: Modifier,
    navController: NavController
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),

        )
    {
        Box(
            modifier = Modifier.height(300.dp)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.primary
            ) {}
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center,

                ) {
                TextItem(
                    text = "Profile",
                    fontWeight = FontWeight.Bold,
                    textColor = MaterialTheme.colorScheme.background,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextItem(
                    text = "Merhaba",
                    fontWeight = FontWeight.Medium,
                    textColor = MaterialTheme.colorScheme.background,
                    fontSize = 14.sp
                )
                TextItem(
                    text = "Furkan Kılıç",
                    fontWeight = FontWeight.ExtraBold,
                    textColor = MaterialTheme.colorScheme.background,
                    fontSize = 30.sp
                )

            }
        }

        Column(
            modifier= Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            FavoritesItem(
                favoriteName = "Favorite Movies",
                onCardClick = {
                    navController.navigate(Screen.FavoriteScreen.route)
                }
            )
            FavoritesItem(
                favoriteName = "Favorite Series",
                onCardClick = {
                    navController.navigate(Screen.FavoriteScreen.route)
                }
            )
        }


    }
}
/*
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    MovieAppTheme {
        ProfileScreen(modifier = Modifier)
    }
}
*/
