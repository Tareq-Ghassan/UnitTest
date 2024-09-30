package com.oppensooq.artbook.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.oppensooq.artbook.ui.state.LoadingImageStatus

@Composable
fun ArtsItem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        SubcomposeAsyncImage(
            contentScale = ContentScale.FillBounds,
            model = "https://opensooqui2.os-cdn.com/api/common/category/Autos.png",
            contentDescription = "Art image",
            modifier = Modifier
                .padding(16.dp)
                .width(64.dp)
                .height(64.dp),
            loading = {
                LoadingImageStatus(LoadingImageStatus.Loading)
            },
            error = {
                LoadingImageStatus(LoadingImageStatus.Error)

            }
        )
        Column {
            Text(text = "Art Name", fontSize = 28.sp)
            Text(text = "Artist Name", fontSize = 20.sp)
            Text(text = "Year", fontSize = 18.sp)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtsItemPreview() {
    ArtsItem()
}