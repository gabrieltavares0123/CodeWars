package com.magrathea.codewars.data.repository

import com.magrathea.codewars.data.local.dao.CompletedChallengeDao
import com.magrathea.codewars.data.local.entity.CompletedChallengeEntity
import com.magrathea.codewars.data.local.entity.UserWithCompletedChallenges
import com.magrathea.codewars.data.remote.entity.CompletedChallengeDto
import com.magrathea.codewars.data.remote.service.CompletedChallengeService
import com.magrathea.codewars.domain.model.CompletedChallenge
import com.magrathea.codewars.domain.repository.CompletedChallengeRepository
import kotlinx.coroutines.flow.collect

class CompletedChallengeRepositoryImpl(
    private val completedChallengeService: CompletedChallengeService,
    private val completedChallengeDao: CompletedChallengeDao,
) : CompletedChallengeRepository {
    override suspend fun findCompletedChallengesByUser(
        username: String,
        page: Int
    ): List<CompletedChallenge> {
        completedChallengeService.findCompletedChallengesByUser(username, page)
            .collect { completedChallengeDtoList ->
                completedChallengeDao.save(completedChallengeDtoList.data.toCompletedChallengeEntityList())
            }

        return completedChallengeDao.allCompletedChallengesByUserName(username, page).toCompletedChallengeDomainList()
    }
}

fun List<CompletedChallengeDto>.toCompletedChallengeEntityList(): List<CompletedChallengeEntity> {
    return this.map {
        CompletedChallengeEntity(
            id = it.id,
            name = it.name,
            slug = it.slug,
            completedAt = it.completedAt,
            completedLanguages = it.completedLanguages,
        )
    }
}

fun UserWithCompletedChallenges.toCompletedChallengeDomainList(): List<CompletedChallenge> {
    return this.completedChallengeEntities.map {
        CompletedChallenge(
            id = it.id,
            name = it.name,
            slug = it.slug,
            completedAt = it.completedAt,
            completedLanguages = it.completedLanguages,
        )
    }
}