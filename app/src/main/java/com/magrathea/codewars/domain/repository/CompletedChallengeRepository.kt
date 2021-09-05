package com.magrathea.codewars.domain.repository

import androidx.lifecycle.LiveData
import com.magrathea.codewars.model.CompletedChallenge
import com.magrathea.codewars.util.Resource

interface CompletedChallengeRepository {
    suspend fun findCompletedChallengesByUser(
        username: String,
        page: Int
    ): LiveData<Resource<List<CompletedChallenge>>>
}