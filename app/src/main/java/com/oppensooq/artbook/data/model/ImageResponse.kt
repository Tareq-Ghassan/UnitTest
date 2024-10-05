package com.oppensooq.artbook.data.model

data class ImageResponse(
    val total: Int,
    val totalHits: Int,
    val hits: List<ImageResult>
)