package com.magrathea.codewars.domain.repository

import androidx.lifecycle.LiveData
import com.magrathea.codewars.domain.model.CompletedChallenge

interface CompletedChallengeRepository {
    suspend fun findCompletedChallengesByUser(
        username: String,
        page: Int
    ): LiveData<List<CompletedChallenge>>
}