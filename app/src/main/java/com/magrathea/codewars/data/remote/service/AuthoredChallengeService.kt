package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.entity.AuthoredChallengeDto
import com.magrathea.codewars.data.remote.entity.PagingResponse
import kotlinx.coroutines.flow.Flow

interface AuthoredChallengeService {
    suspend fun findAuthoredChallengesByUser(
        username: String,
        page: Int
    ): Flow<PagingResponse<List<AuthoredChallengeDto>>>
}