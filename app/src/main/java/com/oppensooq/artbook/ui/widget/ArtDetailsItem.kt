package com.oppensooq.artbook.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage

@Composable
fun ArtDetailsItem(innerPadding: PaddingValues) {
    var name by remember { mutableStateOf("") }
    var artist by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubcomposeAsyncImage(
            contentScale = ContentScale.FillBounds,
            model = "https://opensooqui2.os-cdn.com/api/common/category/Autos.png",
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
        TextField(
            value = name,
            onValueChange = { name = it },
            placeholder = { Text("Enter Name") },
            modifier = Modifier.padding(vertical = 16.dp)
        )
        TextField(
            value = artist,
            onValueChange = { artist = it },
            placeholder = { Text("Enter Artist Name") },
            modifier = Modifier.padding(vertical = 16.dp)
        )
        TextField(
            value = year,
            onValueChange = { year = it },
            placeholder = { Text("Enter Year") },
            modifier = Modifier.padding(vertical = 16.dp)
        )
        ElevatedButton(onClick = {
            println("save")
        }) {
            Text(text = "Save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtDetailsItemPreview() {
    ArtDetailsItem(PaddingValues(16.dp))
}