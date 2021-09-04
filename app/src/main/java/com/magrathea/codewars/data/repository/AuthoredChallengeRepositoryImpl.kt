package com.magrathea.codewars.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.magrathea.codewars.data.local.dao.AuthoredChallengeDao
import com.magrathea.codewars.data.mapper.toAuthoredChallengeDomainList
import com.magrathea.codewars.data.mapper.toAuthoredChallengeEntityList
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
    ): LiveData<List<AuthoredChallenge>> {
        authoredChallengeService.findAuthoredChallengesByUser(username, page)
            .collect { authoredChallengeListDto ->
                authoredChallengeDao.save(
                    authoredChallengeListDto.data.toAuthoredChallengeEntityList(
                        username
                    )
                )
            }

        val authoredChallengeDomainList =
            authoredChallengeDao.allAuthoredChallengesByUserName(username)
                .toAuthoredChallengeDomainList()

        return MutableLiveData(authoredChallengeDomainList)
    }
}