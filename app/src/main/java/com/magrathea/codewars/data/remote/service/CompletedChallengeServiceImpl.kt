package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.CodeWarsApi
import com.magrathea.codewars.model.ChallengeResponse
import com.magrathea.codewars.model.CompletedChallenge
import retrofit2.await
import javax.inject.Inject

class CompletedChallengeServiceImpl @Inject constructor(
    private val codeWarsApi: CodeWarsApi
) : CompletedChallengeService {
    override suspend fun findCompletedChallengesByUser(
        username: String,
        page: Int
    ): ChallengeResponse<CompletedChallenge> {
        return codeWarsApi.findCompletedChallengesByUser(username, page).await()
    }
}