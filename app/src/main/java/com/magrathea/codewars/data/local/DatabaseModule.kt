package com.magrathea.codewars.data.local

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    companion object {
        private const val DATABASE_NAME = "codewars_database"
    }

    @Provides
    fun provideDatabase(@ApplicationContext application: Application): CodeWarsDatabase {
        return Room.databaseBuilder(
            application,
            CodeWarsDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}