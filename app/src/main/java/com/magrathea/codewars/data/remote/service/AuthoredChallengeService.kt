package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.dto.AuthoredChallengeDto
import com.magrathea.codewars.data.remote.dto.PagingResponse
import kotlinx.coroutines.flow.Flow

interface AuthoredChallengeService {
    suspend fun findAuthoredChallengesByUser(
        username: String,
        page: Int
    ): Flow<PagingResponse<List<AuthoredChallengeDto>>>
}