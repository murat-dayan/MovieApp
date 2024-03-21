package com.example.movieapp.presentation.components

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun RatingItem(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.background,
    shape: CornerBasedShape = MaterialTheme.shapes.medium,
    rate:String?
){
    Surface(
        modifier = modifier,
        shape = shape,
        color = backgroundColor
    ) {
        Row (
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Icon(
                imageVector = Icons.Default.Star ,
                contentDescription = null,
                modifier = Modifier.size(15.dp),
                tint = textColor
            )
            Text(
                text = rate.toString(),
                color = textColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
/*
@Preview
@Composable
fun RatingItemPreview(){
    MovieAppTheme {
        RatingItem(rate = "8.5")
    }
}*/
