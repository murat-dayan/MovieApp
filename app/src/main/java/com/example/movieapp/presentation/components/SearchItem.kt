package com.example.movieapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.core.utils.Constants
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
    cardTitle: String,
    mediaType: String
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(150.dp)
            .background(Color.White),
        shape = MaterialTheme.shapes.small,


        ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {
            if (!(imageUrl.isNullOrEmpty())) {
                AsyncImage(
                    model = Constants.IMAGE_URL + imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(150.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.SpaceBetween,

                ) {
                TextItem(
                    text = cardTitle,
                    fontWeight = FontWeight.ExtraBold,
                )
                Row {
                    when (mediaType) {
                        "tv" -> {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_series),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }

                        "movie" -> {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_movie),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }

                        else -> {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_profile),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                    TextItem(text = mediaType)
                }
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun SearchItemPreview() {
    MovieAppTheme {
        SearchItem(modifier = Modifier, imageUrl = "", cardTitle = "Joker", "tv")
    }
}