package com.example.movieapp.presentation.screens.series

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.core.utils.Constants
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.Serie
import com.example.movieapp.presentation.components.LoadingItem
import com.example.movieapp.presentation.components.SeriesItem
import com.example.movieapp.presentation.components.TextItem
import com.example.movieapp.presentation.navigation.Screen

@Composable
fun SeriesScreen(
    modifier: Modifier,
    serieState: SerieState,
    navController: NavController
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        )
    {
         if (serieState.series?.isNotEmpty()!!) {

             LazyVerticalGrid(
                 modifier = Modifier
                     .background(MaterialTheme.colorScheme.primaryContainer),
                 columns = GridCells.Fixed(2),
                 verticalArrangement = Arrangement.spacedBy(10.dp),
                 horizontalArrangement = Arrangement.spacedBy(10.dp),
                 content = {

                     val popularList = serieState.series.filter {
                         it.voteAverage >= 7
                     }
                     item(span = { GridItemSpan(2) }) {
                         HorizontalPageComponent(
                             movieOrSerieList = popularList
                         )
                     }
                     items(serieState.series) { serie ->
                         SeriesItem(
                             imageUrl = serie.posterPath,
                             seriesTitle = serie.name,
                             seriesRate = serie.voteAverage.toString(),
                             onCardClick = {
                                 navController.navigate(Screen.SeriesDetailScreen.createRoute(serie.id))
                             }
                         )
                     }
                 }
             )
         }
     }

     if (serieState.isLoading) {
         LoadingItem()
     }

     if (!(serieState.errorMsg.isNullOrEmpty())) {
         println(serieState.errorMsg)
         Text(
             text = serieState.errorMsg
         )
     }

    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun HorizontalPageComponent(
        movieOrSerieList: List<Serie>
    ) {


        val pagerState = rememberPagerState(
            initialPage = 0,
            initialPageOffsetFraction = 0f
        ) {
            movieOrSerieList.size
        }



        Box {

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                color = MaterialTheme.colorScheme.primary
            ) {}
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextItem(
                        fontSize = 34.sp,
                        textColor = MaterialTheme.colorScheme.primaryContainer,
                        text = stringResource(id = R.string.series)
                    )

                }

                HorizontalPager(
                    state = pagerState,
                    key = { movieOrSerieList[it].id },
                    pageSize = PageSize.Fill
                ) { pageIndex ->

                    AsyncImage(
                        model = Constants.IMAGE_URL + movieOrSerieList[pageIndex].posterPath,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(500.dp)
                    )

                }
            }
        }
    }

