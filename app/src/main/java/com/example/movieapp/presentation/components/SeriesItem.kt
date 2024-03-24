package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp.core.utils.Constants
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun SeriesItem(
    imageUrl:String?,
    seriesTitle:String?,
    seriesRate:String?,
    modifier: Modifier = Modifier,
){

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(300.dp),
        shape = MaterialTheme.shapes.small
    ) {
        Column (
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            AsyncImage(
                model = Constants.IMAGE_URL+ imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    ,

            )
            TextItem(text = seriesTitle.toString())
            RatingItem(rate = seriesRate )
        }
    }
}

/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SeriesItemPreview(){
    MovieAppTheme {
        SeriesItem(imageUrl = null, seriesTitle = "null", seriesRate = "null")
    }
}*/
