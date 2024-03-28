package com.example.movieapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.navigation.Screen
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun FavoritesItem(
    modifier: Modifier = Modifier,
    favoriteName:String,
    onCardClick:()->Unit
) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 12.dp)
            .background(Color.White)
            .clickable {
                       onCardClick()
            }
        ,

    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(Color.White)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            TextItem(text = favoriteName, fontWeight = FontWeight.Bold)
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun FavoritesItemPreview() {
    MovieAppTheme {
        FavoritesItem(favoriteName = "Favorite Movies")
    }

}*/
