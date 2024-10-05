package com.oppensooq.artbook.presentation.ui.widget

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
import com.oppensooq.artbook.data.model.Art
import com.oppensooq.artbook.presentation.ui.state.LoadingImageStatus

@Composable
fun ArtsItem(art: Art) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
    ) {
        SubcomposeAsyncImage(contentScale = ContentScale.FillBounds,
            model = art.imageUrl,
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

            })
        Column {
            Text(text = art.name, fontSize = 28.sp)
            Text(text = art.artistName, fontSize = 20.sp)
            Text(text = art.year, fontSize = 18.sp)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtsItemPreview() {
    ArtsItem(
        Art(
            "1",
            "name",
            "2020",
            "https://opensooqui2.os-cdn.com/api/common/category/Autos.png"
        ),
    )
}