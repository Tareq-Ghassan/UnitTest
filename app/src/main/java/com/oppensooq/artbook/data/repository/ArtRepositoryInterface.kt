package com.oppensooq.artbook.data.repository

import com.oppensooq.artbook.data.model.Art
import com.oppensooq.artbook.data.model.ImageResponse
import com.oppensooq.artbook.util.Resource
import kotlinx.coroutines.flow.StateFlow

interface ArtRepositoryInterface {
    fun getArtFromDB(): List<Art>

    suspend fun addArtToDB(art: Art)

    suspend fun deleteArtFromDB(art: Art)

    suspend fun getImageAPI(query: String): Resource<ImageResponse>
}