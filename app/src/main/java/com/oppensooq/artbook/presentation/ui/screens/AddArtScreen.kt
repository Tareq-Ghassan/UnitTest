package com.oppensooq.artbook.presentation.ui.screens


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.oppensooq.artbook.presentation.ui.widget.ArtDetailsItem

@Composable
fun AddArtsScreen(
    selectedImage: String,
    makeArt: (String, String, String) -> Unit,
    onNavigateToSearch: () -> Unit
) {
    ArtDetailsItem(selectedImage, makeArt, onNavigateToSearch)

}


@Preview(showBackground = true)
@Composable
fun ArtsDetailsScreenPreview() {
    AddArtsScreen("", { _, _, _ -> }, {})
}