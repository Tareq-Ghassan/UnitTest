package com.oppensooq.artbook.data.repository

import com.oppensooq.artbook.data.model.Art
import com.oppensooq.artbook.data.model.ImageResponse
import com.oppensooq.artbook.data.network.ApiService
import com.oppensooq.artbook.util.Resource
import com.oppensooq.artbook.util.Utils.API_KEY
import io.realm.kotlin.Realm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ArtRepository @Inject constructor(
    private val apiService: ApiService,
    private val realm: Realm
) : ArtRepositoryInterface {


    override fun getArtFromDB(): List<Art> {
        return realm.query(Art::class).find()
    }

    override suspend fun addArtToDB(art: Art) {
        realm.writeBlocking {
            copyToRealm(art)
        }
    }

    override suspend fun deleteArtFromDB(art: Art) {
        realm.writeBlocking {
            val cachedArt = query(Art::class, "id == $0", art.id).find()
            delete(cachedArt)
        }
    }

    override suspend fun getImageAPI(query: String): Resource<ImageResponse> {
        return try {
            val res = apiService.getImage(query)
            if (res.isSuccessful) {
                res.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error", null)
            } else {
                return Resource.error("No Data", null)
            }

        } catch (e: Exception) {
            Resource.error("No Data", null)
        }
    }
}