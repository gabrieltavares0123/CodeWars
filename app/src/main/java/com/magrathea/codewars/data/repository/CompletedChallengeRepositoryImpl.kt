package com.magrathea.codewars.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.magrathea.codewars.data.local.dao.CompletedChallengeDao
import com.magrathea.codewars.data.remote.service.CompletedChallengeService
import com.magrathea.codewars.domain.repository.CompletedChallengeRepository
import com.magrathea.codewars.model.CompletedChallenge
import com.magrathea.codewars.util.Resource
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class CompletedChallengeRepositoryImpl @Inject constructor(
    private val completedChallengeService: CompletedChallengeService,
    private val completedChallengeDao: CompletedChallengeDao,
) : CompletedChallengeRepository {
    override suspend fun findCompletedChallengesByUser(
        username: String,
        page: Int
    ): LiveData<Resource<List<CompletedChallenge>>> {
        completedChallengeDao.save(
            completedChallengeService.findCompletedChallengesByUser(username, page).data
        )

        val fromLocalDataSource = completedChallengeDao.allCompletedChallengesByUserName(username)

        return MutableLiveData(Resource.Success(fromLocalDataSource))
    }
}