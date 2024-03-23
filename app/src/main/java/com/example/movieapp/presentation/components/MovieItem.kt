package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
fun MovieItem(
    imageUrl:String?,
    modifier: Modifier = Modifier,
    cardTitle:String?,
    cardRate:String?,
    cardDate:String?,
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(150.dp),
        shape = MaterialTheme.shapes.small

    ) {
        Row {
            AsyncImage(
                model = Constants.IMAGE_URL + imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp)
            )
            Column (
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween,

            ){
                TextItem(
                    text = cardTitle.toString()
                )
                Row(
                    modifier=Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DateItem(
                        date = cardDate
                    )
                    RatingItem(rate = cardRate.toString())
                }
            }
        }
    }
}
@Preview
@Composable
fun CardItemPreview(){
    MovieAppTheme {
        MovieItem(imageUrl = null, cardRate = null, cardTitle = null, cardDate = null)
    }
}
