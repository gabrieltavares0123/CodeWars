package com.magrathea.codewars.data.repository

import com.magrathea.codewars.data.local.dao.AuthoredChallengeDao
import com.magrathea.codewars.data.local.entity.AuthoredChallengeEntity
import com.magrathea.codewars.data.remote.entity.AuthoredChallengeDto
import com.magrathea.codewars.data.remote.service.AuthoredChallengeService
import com.magrathea.codewars.domain.model.AuthoredChallenge
import com.magrathea.codewars.domain.repository.AuthoredChallengeRepository
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class AuthoredChallengeRepositoryImpl @Inject constructor(
    private val authoredChallengeDao: AuthoredChallengeDao,
    private val authoredChallengeService: AuthoredChallengeService,
) : AuthoredChallengeRepository {
    override suspend fun findAuthoredChallengesByUser(
        username: String,
        page: Int
    ): List<AuthoredChallenge> {
        authoredChallengeService.findAuthoredChallengesByUser(username, page)
            .collect { authoredChallengeListDto ->
                authoredChallengeDao.save(
                    authoredChallengeListDto.data.toAuthoredChallengeEntityList(
                        username
                    )
                )
            }

        return authoredChallengeDao.allAuthoredChallengesByUserName(username)
            .toAuthoredChallengeDomainList()
    }
}

fun List<AuthoredChallengeDto>.toAuthoredChallengeEntityList(username: String): List<AuthoredChallengeEntity> {
    return this.map {
        AuthoredChallengeEntity(
            id = it.id,
            name = it.name,
            description = it.description,
            rank = it.rank,
            tags = it.tags,
            languages = it.languages,
            userNameAuthor = username,
        )
    }
}

fun List<AuthoredChallengeEntity>.toAuthoredChallengeDomainList(): List<AuthoredChallenge> {
    return this.map {
        AuthoredChallenge(
            id = it.id,
            name = it.name,
            description = it.description,
            rank = it.rank,
            rankName = it.rankName,
            tags = it.tags,
            languages = it.languages,
        )
    }
}