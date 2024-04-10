package com.example.movieapp.presentation.components

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun TextItem(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Clip,
    lineHeight: TextUnit = TextUnit.Unspecified,
    fontFamily: FontFamily = FontFamily.Default,
    backgroundColor: Color = Color.Transparent
) {
    Box (
        modifier = Modifier.background(backgroundColor, RoundedCornerShape(10.dp))
            .padding(5.dp)
    ){
        Text(
            text = text,
            modifier = modifier,
            color = textColor,
            fontSize = fontSize,
            fontWeight = fontWeight,
            maxLines = maxLines,
            overflow = overflow,
            lineHeight = lineHeight,
            fontFamily = fontFamily,

            )
    }
}
@Preview(showBackground = true)
@Composable
fun TextItemPreview(){
    MovieAppTheme {
        TextItem(text = "22-20-2013", textColor = Color.White)
    }
}
