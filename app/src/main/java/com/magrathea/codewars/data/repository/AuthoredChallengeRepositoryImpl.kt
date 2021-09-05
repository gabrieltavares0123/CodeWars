package com.magrathea.codewars.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.magrathea.codewars.data.local.dao.AuthoredChallengeDao
import com.magrathea.codewars.data.remote.service.AuthoredChallengeService
import com.magrathea.codewars.domain.repository.AuthoredChallengeRepository
import com.magrathea.codewars.model.AuthoredChallenge
import com.magrathea.codewars.util.Resource
import javax.inject.Inject

class AuthoredChallengeRepositoryImpl @Inject constructor(
    private val authoredChallengeDao: AuthoredChallengeDao,
    private val authoredChallengeService: AuthoredChallengeService,
) : AuthoredChallengeRepository {
    override suspend fun findAuthoredChallengesByUser(
        username: String,
        page: Int
    ): LiveData<Resource<List<AuthoredChallenge>>> {
        val authoredChallenges =
            authoredChallengeService.findAuthoredChallengesByUser(username, page).data
        authoredChallenges.forEach {
            AuthoredChallenge(
                id = it.id,
                name = it.name,
                description = it.description,
                rank = it.rank,
                rankName = it.rankName,
                tags = it.tags,
                languages = it.languages,
                userNameAuthor = username,
            )
        }
        authoredChallengeDao.save(
            authoredChallenges
        )

        val fromLocalSource = authoredChallengeDao.allAuthoredChallengesByUserName(username)

        return MutableLiveData(Resource.Success(fromLocalSource))
    }
}