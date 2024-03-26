package com.example.movieapp.presentation.screens.movies

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.core.utils.Constants
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.presentation.components.LoadingItem
import com.example.movieapp.presentation.components.MovieItem
import com.example.movieapp.presentation.components.TextItem

@Composable
fun MoviesScreen(
    modifier: Modifier,
    //movieState: MovieState
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {


        /* if (movieState.movies?.isNotEmpty()!!){

                val popularList = movieState.movies.filter {
                    it.voteAverage>=7
                }

                LazyColumn (
                    modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer),

                    ){
                    item {
                        HorizontalPageComponent(movieOrSerieList = popularList )
                    }
                    items(movieState.movies){movie->
                        MovieItem(
                            imageUrl = movie.posterPath ,
                            cardTitle = movie.title,
                            cardRate = movie.voteAverage.toString(),
                            cardDate = movie.releaseDate
                        )
                    }
                }
            }
        }

        if (movieState.isLoading){
            LoadingItem()
        }

        if (!(movieState.errorMsg.isNullOrEmpty())){
            println(movieState.errorMsg)
            Text(
                text = movieState.errorMsg
            )
        }*/


    }

    /*@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview(){
    MoviesScreen(modifier = Modifier, movieState = null)
}*/

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun HorizontalPageComponent(
        movieOrSerieList: List<Movie>
    ) {


        val pagerState = rememberPagerState(
            initialPage = 0,
            initialPageOffsetFraction = 0f
        ) {
            movieOrSerieList.size
        }



        Box {

            Surface(
                modifier = Modifier.fillMaxWidth().height(250.dp),
                color = MaterialTheme.colorScheme.primary
            ) {}
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextItem(
                        fontSize = 34.sp,
                        textColor = MaterialTheme.colorScheme.primaryContainer,
                        text = "Movies"
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
                        modifier = Modifier.fillMaxWidth().height(500.dp)
                    )

                }
            }
        }
    }
}
        
























