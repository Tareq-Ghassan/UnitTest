package com.oppensooq.artbook.presentation.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.oppensooq.artbook.data.model.Art
import com.oppensooq.artbook.presentation.ui.widget.ArtsItem

@Composable
fun ArtsScreen(
    deleteArt: (art: Art) -> Unit,
    arts: List<Art>,
    onNavigateToAdd: () -> Unit,
) {
    Scaffold(floatingActionButton = {
        IconButton(
            colors = IconButtonColors(
                containerColor = Color.Red,
                contentColor = Color.White,
                disabledContainerColor = Color.Red,
                disabledContentColor = Color.White
            ), onClick = { onNavigateToAdd() }) {
            Icon(Icons.Filled.Add, contentDescription = "Localized description")
        }
    }) { innerPadding ->
        val ignore = innerPadding
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(arts, key = { it.id }) { art ->
                ArtsItem(art, deleteArt)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtsScreenPreview() {
    ArtsScreen({}, arts = emptyList(), {
        println("clicked")
    })
}