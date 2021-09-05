package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.CodeWarsApi
import com.magrathea.codewars.data.remote.entity.AuthoredChallengeDto
import com.magrathea.codewars.data.remote.entity.PagingResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthoredChallengeServiceImpl @Inject constructor(
    private val codeWarsApi: CodeWarsApi
) : AuthoredChallengeService {
    override suspend fun findAuthoredChallengesByUser(
        username: String,
        page: Int
    ): Flow<PagingResponse<List<AuthoredChallengeDto>>> {
        return codeWarsApi.findAuthoredChallengesByUser(username, page)
    }
}