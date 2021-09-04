package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.entity.CompletedChallengeDto
import com.magrathea.codewars.data.remote.entity.PagingResponse
import kotlinx.coroutines.flow.Flow

interface CompletedChallengeService {
    suspend fun findCompletedChallengesByUser(
        username: String,
        page: Int
    ): Flow<PagingResponse<List<CompletedChallengeDto>>>
}