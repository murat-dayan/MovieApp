package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp.core.utils.Constants

@Composable
fun DetailToolBar(
    imageUrl :String,
    rateText:String,
    onBackIconClick:()->Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        AsyncImage(
            model = Constants.IMAGE_URL + imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconItem(
                onIconClick = {
                              onBackIconClick()
                },
                color = Color.Blue,
                iconTintColor = Color.White,
                icon = Icons.Default.ArrowBack,

                )
            IconItem(
                onIconClick = { /*TODO*/ },
                color = Color.White,
                iconTintColor = Color.Blue,
                icon = Icons.Default.Favorite,

                )
        }
        RatingItem(
            rate = rateText,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 16.dp)
        )
    }
}