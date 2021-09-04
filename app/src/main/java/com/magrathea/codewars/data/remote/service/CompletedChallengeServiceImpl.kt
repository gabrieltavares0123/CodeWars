package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.CodeWarsApi
import com.magrathea.codewars.data.remote.entity.CompletedChallengeDto
import com.magrathea.codewars.data.remote.entity.PagingResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CompletedChallengeServiceImpl @Inject constructor(
    private val codeWarsApi: CodeWarsApi
) : CompletedChallengeService {
    override suspend fun findCompletedChallengesByUser(
        username: String,
        page: Int
    ): Flow<PagingResponse<List<CompletedChallengeDto>>> {
        return codeWarsApi.findCompletedChallengesByUser(username, page)
    }
}