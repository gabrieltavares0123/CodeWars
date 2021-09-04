package com.magrathea.codewars.data.repository

import com.magrathea.codewars.data.local.dao.AuthoredChallengeDao
import com.magrathea.codewars.data.local.dao.CompletedChallengeDao
import com.magrathea.codewars.data.local.dao.UserDao
import com.magrathea.codewars.data.remote.service.AuthoredChallengeService
import com.magrathea.codewars.data.remote.service.CompletedChallengeService
import com.magrathea.codewars.data.remote.service.UserService
import com.magrathea.codewars.domain.repository.AuthoredChallengeRepository
import com.magrathea.codewars.domain.repository.CompletedChallengeRepository
import com.magrathea.codewars.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
    @Provides
    fun provideUserRepository(userDao: UserDao, userService: UserService): UserRepository {
        return UserRepositoryImpl(userDao, userService)
    }

    @Provides
    fun provideAuthoredChallengeRepository(
        authoredChallengeDao: AuthoredChallengeDao,
        authoredChallengeService: AuthoredChallengeService
    ): AuthoredChallengeRepository {
        return AuthoredChallengeRepositoryImpl(authoredChallengeDao, authoredChallengeService)
    }

    @Provides
    fun provideCompletedChallengeRepository(
        completedChallengeDao: CompletedChallengeDao,
        completedChallengeService: CompletedChallengeService
    ): CompletedChallengeRepository {
        return CompletedChallengeRepositoryImpl(completedChallengeService, completedChallengeDao)
    }
}