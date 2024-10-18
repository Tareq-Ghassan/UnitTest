package com.oppensooq.artbook.data.repository

import com.oppensooq.artbook.data.model.Art
import com.oppensooq.artbook.data.model.ImageResponse
import com.oppensooq.artbook.util.Resource

class FakeArtRepository : ArtRepositoryInterface {

    private val arts = mutableListOf<Art>()

    override fun getArtFromDB(): List<Art> {
        return arts
    }

    override suspend fun addArtToDB(art: Art) {
        arts.add(art)
        refreshData()
    }

    override suspend fun deleteArtFromDB(art: Art) {
        arts.remove(art)
        refreshData()
    }

    override suspend fun getImageAPI(query: String): Resource<ImageResponse> {
        return Resource.success(ImageResponse(0, 0,emptyList()))
    }

    private fun refreshData(){
        arts.clear()
        arts.addAll(getArtFromDB())
    }
}