package com.example.movieapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.graphics.Color
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
    onCardClick: ()->Unit
){

        Card(
            modifier = Modifier
                .background(Color.Transparent)
                .height(300.dp)
                .clickable {
                           onCardClick()
                }
                ,
            shape = MaterialTheme.shapes.small,

        ) {
            Column(
                modifier = Modifier.fillMaxSize().background(Color.White)
            ) {
                AsyncImage(
                    model = Constants.IMAGE_URL + imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .aspectRatio(1f) // Görüntülerinizin farklı bir en-boy oranına sahip olduğunu varsayarak
                )

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    TextItem(
                        text = seriesTitle.toString(),
                        modifier = Modifier.padding(start = 6.dp, top = 6.dp, bottom = 6.dp)
                    )

                    RatingItem(
                        rate = seriesRate,
                        modifier = Modifier.padding(start = 6.dp, bottom = 6.dp)
                    )
                }
            }

        }

}

/*@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SeriesItemPreview(){
    MovieAppTheme {
        SeriesItem(imageUrl = null, seriesTitle = "ASDSAD", seriesRate = "ASDSAD")
    }
}*/
