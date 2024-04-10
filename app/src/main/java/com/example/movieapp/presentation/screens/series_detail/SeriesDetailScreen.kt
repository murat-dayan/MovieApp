package com.example.movieapp.presentation.screens.series_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.movieapp.presentation.components.ActorsActressItem
import com.example.movieapp.presentation.components.DateItem
import com.example.movieapp.presentation.components.DetailToolBar
import com.example.movieapp.presentation.components.IconItem
import com.example.movieapp.presentation.components.LoadingItem
import com.example.movieapp.presentation.components.TextItem
import com.example.movieapp.presentation.navigation.Screen

@Composable
fun SeriesDetailScreen(
    modifier: Modifier,
    serie_Id: Int,
    navController: NavController,
    seriesDetailViewModel: SeriesDetailViewModel
) {

    var verticalScrollState = rememberScrollState()

    var showIcons by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = serie_Id) {
        seriesDetailViewModel.getSerieDetail(serie_Id)
        seriesDetailViewModel.getSerieCast(serie_Id)
    }

    var serieDetailState =
        seriesDetailViewModel.serieDetailState.collectAsStateWithLifecycle().value
    var serieCastState = seriesDetailViewModel.serieCastState.collectAsStateWithLifecycle().value




    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()

        ) {

            if (serieDetailState.serieDetailModel != null && !(serieCastState.castList.isNullOrEmpty())) {
                val serieDetailModel = serieDetailState.serieDetailModel!!
                val castList = serieCastState.castList
                serieDetailModel.backdropPath?.let {
                    DetailToolBar(
                        imageUrl = it,
                        rateText = serieDetailModel.voteAverage.toString(),
                        onBackIconClick = {
                            navController.navigate(Screen.SeriesScreen.route)
                        }
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .verticalScroll(verticalScrollState)
                        .padding(horizontal = 10.dp)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    TextItem(
                        text = serieDetailModel.originalName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        for (genre in serieDetailModel.genres) {
                            TextItem(text = genre.name + ",")
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))

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
                        text = serieDetailModel.overview,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        TextItem(
                            text = "Episodes: ${serieDetailModel.numberOfEpisodes.toString()}",
                            textColor = Color.White,
                            backgroundColor = Color.Black
                        )
                        TextItem(
                            text = "Seasons: ${serieDetailModel.numberOfSeasons.toString()}",
                            textColor = Color.White,
                            backgroundColor = Color.Black
                        )
                    }
                    TextItem(
                        text = "Actors/Actress",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textColor = Color.Black
                    )
                    LazyRow {
                        items(castList!!){castModel->
                            ActorsActressItem(
                                imageUrl = castModel.profilePath?:"" ,
                                actorActressName = castModel.name
                            )
                        }
                    }
                }
            }
            if (serieDetailState.isLoading || serieCastState.isLoading) {
                LoadingItem()
            }
            if (!(serieDetailState.errorMsg.isNullOrEmpty() || serieCastState.errorMsg.isNullOrEmpty())) {
                Text(text = serieDetailState.errorMsg.toString())
                println(serieDetailState.errorMsg.toString())
            }
        }

    }
}