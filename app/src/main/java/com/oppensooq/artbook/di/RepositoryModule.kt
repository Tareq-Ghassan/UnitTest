package com.oppensooq.artbook.di

import com.oppensooq.artbook.data.network.ApiService
import com.oppensooq.artbook.data.repository.ArtRepository
import com.oppensooq.artbook.data.repository.ArtRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideArtRepository(
        apiService: ApiService,
        realm: Realm
    ): ArtRepositoryInterface {
        return ArtRepository(apiService, realm)
    }
}