package com.oppensooq.artbook.di

import com.oppensooq.artbook.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class,NetworkModule::class, DatabaseModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}