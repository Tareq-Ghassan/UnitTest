package com.oppensooq.artbook.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.oppensooq.artbook.ui.theme.ArtBookTheme
import com.oppensooq.artbook.ui.widget.ArtsItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtsScreen() {
    ArtBookTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
            TopAppBar(title = { Text("Art Book") })
        }, floatingActionButton = {
            IconButton(
                colors = IconButtonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Red,
                    disabledContentColor = Color.White
                ), onClick = { println("Hello") }) {
                Icon(Icons.Filled.Add, contentDescription = "Localized description")
            }
        }) { innerPadding ->
            LazyColumn(modifier = Modifier.padding(innerPadding)) {
                items(10) {
                    ArtsItem()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtsScreenPreview() {
    ArtsScreen()
}