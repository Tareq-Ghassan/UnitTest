package com.oppensooq.artbook.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage


@Composable
fun ImageApi(innerPadding: PaddingValues) {
    var loading by remember { mutableStateOf(true) }
    var name by remember { mutableStateOf("") }
    val listOfImages = listOf(
        "https://opensooqui2.os-cdn.com/api/common/category/Autos.png",
        "https://opensooqui2.os-cdn.com/api/common/category/Autos.png",
        "https://opensooqui2.os-cdn.com/api/common/category/Autos.png",
    )
    Column(
        modifier = Modifier.padding(innerPadding).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (loading) {
                CircularProgressIndicator(
                    modifier = Modifier.padding(16.dp)
                )
            }
            TextField(
                value = name,
                onValueChange = { name = it },
                placeholder = { Text("Search Image") },
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
            )
        }
        LazyColumn {
            items(listOfImages) {
                SubcomposeAsyncImage(
                    contentScale = ContentScale.FillBounds,
                    model =it,
                    contentDescription = "Art image",
                    modifier = Modifier
                        .padding(16.dp)
                        .width(132.dp)
                        .height(132.dp),
                    loading = {
                        LoadingImageStatus(com.oppensooq.artbook.ui.state.LoadingImageStatus.Loading)
                    },
                    error = {
                        LoadingImageStatus(com.oppensooq.artbook.ui.state.LoadingImageStatus.Error)

                    }
                )
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun ImageApiPreview() {
    ImageApi(PaddingValues(16.dp))
}