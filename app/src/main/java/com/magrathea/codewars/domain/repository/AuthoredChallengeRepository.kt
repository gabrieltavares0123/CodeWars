package com.magrathea.codewars.domain.repository

import androidx.lifecycle.LiveData
import com.magrathea.codewars.domain.model.AuthoredChallenge

interface AuthoredChallengeRepository {
    suspend fun findAuthoredChallengesByUser(
        username: String,
        page: Int
    ): LiveData<List<AuthoredChallenge>>
}