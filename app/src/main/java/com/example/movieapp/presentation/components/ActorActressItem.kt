package com.example.movieapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.core.utils.Constants
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun ActorsActressItem(
    imageUrl:String,
    actorActressName:String
) {

    Column(

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = /*Constants.IMAGE_URL + */imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        TextItem(text = actorActressName)
    }

}

@Preview(showBackground = true)
@Composable
fun ActorsActressItemPreview() {
    MovieAppTheme {
        ActorsActressItem(
            "https://example.com/image.jpg",
            "Heath Ledger")
    }

}