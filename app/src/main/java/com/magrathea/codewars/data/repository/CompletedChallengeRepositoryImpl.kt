package com.magrathea.codewars.data.repository

import com.magrathea.codewars.data.local.dao.CompletedChallengeDao
import com.magrathea.codewars.data.mapper.toCompletedChallengeDomainList
import com.magrathea.codewars.data.mapper.toCompletedChallengeEntityList
import com.magrathea.codewars.data.remote.service.CompletedChallengeService
import com.magrathea.codewars.domain.model.CompletedChallenge
import com.magrathea.codewars.domain.repository.CompletedChallengeRepository
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class CompletedChallengeRepositoryImpl @Inject constructor(
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