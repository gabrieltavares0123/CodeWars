package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.dto.CompletedChallengeDto
import com.magrathea.codewars.data.remote.dto.PagingResponse
import kotlinx.coroutines.flow.Flow

interface CompletedChallengeService {
    suspend fun findCompletedChallengesByUser(
        username: String,
        page: Int
    ): Flow<PagingResponse<List<CompletedChallengeDto>>>
}