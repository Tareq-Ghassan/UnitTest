package com.oppensooq.artbook.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.oppensooq.artbook.ui.theme.ArtBookTheme
import com.oppensooq.artbook.ui.widget.ImageApi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchImageScreen() {
    ArtBookTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
            TopAppBar(title = { Text("Search On Image") })
        }) { innerPadding ->
            ImageApi(innerPadding)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SearchImageScreenPreview() {
    SearchImageScreen()
}