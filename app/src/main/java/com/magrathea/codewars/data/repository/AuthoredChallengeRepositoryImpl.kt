package com.magrathea.codewars.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.magrathea.codewars.data.local.dao.AuthoredChallengeDao
import com.magrathea.codewars.data.remote.service.AuthoredChallengeService
import com.magrathea.codewars.domain.repository.AuthoredChallengeRepository
import com.magrathea.codewars.model.AuthoredChallenge
import com.magrathea.codewars.util.Resource
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class AuthoredChallengeRepositoryImpl @Inject constructor(
    private val authoredChallengeDao: AuthoredChallengeDao,
    private val authoredChallengeService: AuthoredChallengeService,
) : AuthoredChallengeRepository {
    override suspend fun findAuthoredChallengesByUser(
        username: String,
        page: Int
    ): LiveData<Resource<List<AuthoredChallenge>>> {
        authoredChallengeDao.save(
            authoredChallengeService.findAuthoredChallengesByUser(username, page).data
        )

        val fromLocalSource = authoredChallengeDao.allAuthoredChallengesByUserName(username)

        return MutableLiveData(Resource.Success(fromLocalSource))
    }
}