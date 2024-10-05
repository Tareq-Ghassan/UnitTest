package com.oppensooq.artbook.presentation.ui.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
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
import com.oppensooq.artbook.data.model.ImageResult
import com.oppensooq.artbook.presentation.ui.state.LoadingImageStatus


@Composable
fun ImageApi(
    images:List<ImageResult>,
    loading: Boolean,
    searchImage: (String) -> Unit,
    setSelectedImage: (String) -> Unit,
) {
    var query by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
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
                value = query,
                onValueChange = { query = it },
                placeholder = { Text("Search Image") },
                modifier = Modifier
                    .padding(16.dp)
                    .width(if (loading) 200.dp else 250.dp)
            )
            ElevatedButton(onClick = {
                searchImage(query)
            }) {
                Text(text = "Search")
            }
        }
        LazyColumn {
            items(images) {
                SubcomposeAsyncImage(
                    contentScale = ContentScale.FillBounds,
                    model = it.userImageURL,
                    contentDescription = "Art image",
                    modifier = Modifier
                        .padding(16.dp)
                        .width(132.dp)
                        .height(132.dp).clickable {
                            setSelectedImage(it.userImageURL)
                        },
                    loading = {
                        LoadingImageStatus(LoadingImageStatus.Loading)
                    },
                    error = {
                        LoadingImageStatus(LoadingImageStatus.Error)

                    }
                )
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun ImageApiPreview() {
    ImageApi(emptyList(),false,{},{})
}