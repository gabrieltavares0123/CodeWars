package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.model.AuthoredChallenge
import com.magrathea.codewars.model.ChallengeResponse
import kotlinx.coroutines.flow.Flow

interface AuthoredChallengeService {
    suspend fun findAuthoredChallengesByUser(
        username: String,
        page: Int
    ): ChallengeResponse<AuthoredChallenge>
}