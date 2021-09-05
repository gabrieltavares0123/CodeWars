package com.magrathea.codewars.domain.repository

import androidx.lifecycle.LiveData
import com.magrathea.codewars.model.AuthoredChallenge
import com.magrathea.codewars.util.Resource

interface AuthoredChallengeRepository {
    suspend fun findAuthoredChallengesByUser(
        username: String,
        page: Int
    ): LiveData<Resource<List<AuthoredChallenge>>>
}