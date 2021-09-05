package com.magrathea.codewars.data.local

import android.content.Context
import androidx.room.Room
import com.magrathea.codewars.data.local.dao.AuthoredChallengeDao
import com.magrathea.codewars.data.local.dao.CompletedChallengeDao
import com.magrathea.codewars.data.local.dao.UserDao
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
    fun provideDatabase(@ApplicationContext application: Context): CodeWarsDatabase {
        return Room.databaseBuilder(
            application,
            CodeWarsDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideUserDao(codeWarsDatabase: CodeWarsDatabase): UserDao {
        return codeWarsDatabase.userDao()
    }

    @Provides
    fun provideAuthoredChallengeDao(codeWarsDatabase: CodeWarsDatabase): AuthoredChallengeDao {
        return codeWarsDatabase.authoredChallengeDao()
    }

    @Provides
    fun provideCompletedChallengeDao(codeWarsDatabase: CodeWarsDatabase): CompletedChallengeDao {
        return codeWarsDatabase.completedChallengeDao()
    }
}