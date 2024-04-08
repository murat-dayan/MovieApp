package com.example.movieapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun IconItem(
    onIconClick: () -> Unit,
    color: Color,
    iconTintColor: Color,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    size: Int = 40,
    iconSize:Int = 24
) {

    Box(
        modifier = modifier
            .size(size.dp)
            .clip(CircleShape)
            .background(color)
            .clickable(onClick = { onIconClick() })
            .padding(all = 4.dp)
            ,

        contentAlignment = Alignment.Center
    ) {
        Icon(
            icon,
            contentDescription = "Yeni Ekle",
            tint = iconTintColor,
            modifier = Modifier.size(iconSize.dp),

        )
    }

}


@Composable
@Preview(showBackground = true)
fun IconItemPreview() {

        IconItem(
            onIconClick = {},
            color = Color.Black,
            iconTintColor = Color.Blue,
            icon = Icons.Default.Favorite,
            modifier = Modifier
        )

}



