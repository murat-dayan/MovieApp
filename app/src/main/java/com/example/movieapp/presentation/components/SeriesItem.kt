package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun SeriesItem(
    imageUrl:String?,
    seriesTitle:String?,
    seriesRate:String?
){

    Card(

    ) {
        Column {
            AsyncImage(
                model = imageUrl,
                contentDescription = null
            )
            TextItem(text = seriesTitle.toString())
            RatingItem(rate = seriesRate )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SeriesItemPreview(){
    MovieAppTheme {
        SeriesItem(imageUrl = null, seriesTitle = "null", seriesRate = "null")
    }
}