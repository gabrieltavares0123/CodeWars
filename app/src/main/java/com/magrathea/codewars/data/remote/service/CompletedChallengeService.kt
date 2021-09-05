package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.model.ChallengeResponse
import com.magrathea.codewars.model.CompletedChallenge

interface CompletedChallengeService {
    suspend fun findCompletedChallengesByUser(
        username: String,
        page: Int
    ): ChallengeResponse<CompletedChallenge>
}