package com.example.movieapp.presentation.screens.movies_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R
import com.example.movieapp.presentation.components.ActorsActressItem
import com.example.movieapp.presentation.components.DateItem
import com.example.movieapp.presentation.components.IconItem
import com.example.movieapp.presentation.components.RatingItem
import com.example.movieapp.presentation.components.TextItem
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesDetailScreen(
    modifier: Modifier = Modifier,
    movieId:Int
) {

    println(movieId)

    var verticalScrollState = rememberScrollState()

    var showIcons by remember {
        mutableStateOf(false)
    }


    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.joker_image),
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
                        onIconClick = { /*TODO*/ },
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
                    rate = "8.5",
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 16.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .verticalScroll(verticalScrollState)
                    .padding(horizontal = 10.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                TextItem(text = "Breaking", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(10.dp))
                TextItem(text = "Drama, Crime")
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconItem(
                        onIconClick = { /*TODO*/ },
                        color = Color.White,
                        iconTintColor = Color.Blue,
                        icon = Icons.Default.PlayArrow
                    )
                    TextItem(text = "102 min")
                    Spacer(modifier = Modifier.width(10.dp))
                    DateItem(date = "22-11-2232")
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    //horizontalArrangement = Arrangement.SpaceEvenly
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconItem(
                            onIconClick = {
                                showIcons = !showIcons
                            },
                            color = Color.Blue,
                            iconTintColor = Color.White,
                            icon = Icons.Default.Star,
                            modifier = Modifier.padding(horizontal = 5.dp),
                            size = 50
                        )
                        TextItem(text = "Score", fontSize = 14.sp)
                    }
                    if (showIcons) {
                        Divider(
                            color = Color.Gray,
                            modifier = Modifier
                                .height(60.dp)  //fill the max height
                                .width(1.dp)
                        )
                        for (i in 0..4) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                IconItem(
                                    onIconClick = { /*TODO*/ },
                                    color = Color.White,
                                    iconTintColor = Color.Blue,
                                    icon = Icons.Default.Star,
                                    modifier = Modifier.padding(horizontal = 5.dp),
                                    size = 50,
                                    iconSize = 50
                                )
                                TextItem(text = "", fontSize = 14.sp)
                            }


                        }
                    } else {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconItem(
                                onIconClick = {
                                },
                                color = Color.Blue,
                                iconTintColor = Color.White,
                                icon = Icons.Default.Share,
                                modifier = Modifier.padding(horizontal = 5.dp),
                                size = 50
                            )
                            TextItem(text = "Share", fontSize = 14.sp)
                        }

                    }


                }
                Text(
                    text = "overview movie",
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                TextItem(
                    text = "Actors/Actress",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textColor = Color.Black
                )
                ActorsActressItem(
                    imageUrl = "https://upload.wikimedia.org/wikipedia/commons/e/ea/Heath_Ledger_%282%29.jpg",
                    actorActressName = "Heath LEdger"
                )
            }
        }

    }

}

/*
@Composable
@Preview(showBackground = true)
fun MoviesDetailScreenPreview() {
    MovieAppTheme {
        MoviesDetailScreen()
    }
}*/
