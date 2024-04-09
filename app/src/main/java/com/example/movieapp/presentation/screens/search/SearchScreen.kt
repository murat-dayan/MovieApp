package com.example.movieapp.presentation.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.movieapp.R
import com.example.movieapp.presentation.components.LoadingItem
import com.example.movieapp.presentation.components.MovieItem
import com.example.movieapp.presentation.components.SearchItem
import com.example.movieapp.presentation.components.TextItem
import com.example.movieapp.presentation.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    modifier: Modifier,
    searchViewModel: SearchViewModel,
    navController: NavController
) {

    var searchText by remember { mutableStateOf("") }
    val searchModelState = searchViewModel.searchModelState.collectAsStateWithLifecycle().value

    println(searchModelState.isLoading)
    if (searchModelState.seriesOrMovies?.isNotEmpty()!!) {
        println(searchModelState.seriesOrMovies[0].name)
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),

        )
    {

        Box(
            modifier = Modifier.height(300.dp)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.primary
            ) {}
            TextItem(
                text = "Search",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textColor = MaterialTheme.colorScheme.background,
                modifier = Modifier.padding(50.dp)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextField(
                    value = searchText,
                    onValueChange = {
                        searchText = it
                        searchViewModel.searchMovie(searchText)
                    },
                    placeholder = { Text(text = stringResource(id = R.string.searchPlaceholder)) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    maxLines = 1,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,

                        ),
                    shape = RectangleShape,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search
                    ),
                    singleLine = true,
                    textStyle = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 20.sp
                    )


                )
            }
        }

        if (searchModelState.seriesOrMovies.isNotEmpty()) {

            LazyColumn(
                modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer),

                ) {

                items(searchModelState.seriesOrMovies) { serieOrMovieResult ->
                    SearchItem(
                        imageUrl = serieOrMovieResult.posterPath?: "",
                        cardTitle = if (serieOrMovieResult.name.isNullOrEmpty()) serieOrMovieResult.title!! else serieOrMovieResult.name,
                        mediaType = serieOrMovieResult.mediaType ?:"meditype",
                        onCardClick = {
                            if (serieOrMovieResult.mediaType!!.contains("tv")){
                                navController.navigate(Screen.SeriesDetailScreen.createRoute(serieOrMovieResult.id))
                            }else if (serieOrMovieResult.mediaType!!.contains("movie")){
                                navController.navigate(Screen.MoviesDetailScreen.createRoute(serieOrMovieResult.id))
                            }else{
                                println("this is not movie or tv series")
                            }
                        }
                    )
                }
            }
        }


        if (searchModelState.isLoading) {
            LoadingItem()
        }

        if (!(searchModelState.errorMsg.isNullOrEmpty())) {
            println(searchModelState.errorMsg)

        }
    }
}

