package com.oppensooq.artbook.presentation.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import com.oppensooq.artbook.presentation.ui.state.LoadingImageStatus
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.oppensooq.artbook.R

@Composable
fun ArtDetailsItem(
    selectedImage: String,
    makeArt: (String, String, String) -> Unit,
    onNavigateToSearch: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var artist by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (selectedImage.isEmpty()) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .width(132.dp)
                    .height(132.dp)
                    .clickable {
                        onNavigateToSearch()
                    },
                painter = painterResource(id = R.drawable.ic_upload),
                contentDescription = "Art image"
            )
        } else {
            SubcomposeAsyncImage(
                contentScale = ContentScale.FillBounds,
                model = selectedImage,
                contentDescription = "Art image",
                modifier = Modifier
                    .padding(16.dp)
                    .width(132.dp)
                    .height(132.dp)
                    .clickable {
                        onNavigateToSearch()
                    },
                loading = {
                    LoadingImageStatus(LoadingImageStatus.Loading)
                },
                error = {
                    LoadingImageStatus(LoadingImageStatus.Error)

                }
            )
        }

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
            makeArt(
                name,
                artist,
                year
            )
        }) {
            Text(text = "Save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtDetailsItemPreview() {
    ArtDetailsItem("", { _, _, _ -> }, {})
}