package com.oppensooq.artbook.presentation.ui.screens


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.oppensooq.artbook.data.model.ImageResult
import com.oppensooq.artbook.presentation.ui.widget.ImageApi

@Composable
fun SearchImageScreen(
    images: List<ImageResult>,
    loading: Boolean,
    searchImage: (String) -> Unit,
    setSelectedImage: (String) -> Unit,
    ) {
    ImageApi(
        images,
        loading,
        searchImage,
        setSelectedImage
    )
}


@Preview(showBackground = true)
@Composable
fun SearchImageScreenPreview() {
    SearchImageScreen(emptyList(),false, {}, {})
}