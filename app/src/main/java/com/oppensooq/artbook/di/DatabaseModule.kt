package com.oppensooq.artbook.di

import com.oppensooq.artbook.data.model.Art
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideRealm(): Realm {
        val config = RealmConfiguration.Builder(
            schema = setOf(
                Art::class
            )
        ).name("artBook.realm")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()
        return Realm.open(config)
    }
}