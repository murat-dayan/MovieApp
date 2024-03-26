package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun DateItem(
    modifier: Modifier= Modifier,
    color:Color = MaterialTheme.colorScheme.primary,
    date:String?
){

    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Icon(imageVector = Icons.Default.DateRange, contentDescription = null, tint = color)
        TextItem(
            text = date.toString(),
            fontSize = 16.sp
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DateItemPreview(){
    MovieAppTheme {
        DateItem(
            date = "22-10-2012"
        )
    }
}
