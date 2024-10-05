package com.oppensooq.artbook.data.network

import com.oppensooq.artbook.data.model.ImageResponse
import com.oppensooq.artbook.util.Utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("/api/")
    suspend fun getImage(
        @Query("q") searchQuery: String,
        @Query("key") apiKey: String= API_KEY
    ): Response<ImageResponse>

}
