package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.CodeWarsApi
import com.magrathea.codewars.model.AuthoredChallenge
import com.magrathea.codewars.model.ChallengeResponse
import retrofit2.await
import javax.inject.Inject

class AuthoredChallengeServiceImpl @Inject constructor(
    private val codeWarsApi: CodeWarsApi
) : AuthoredChallengeService {
    override suspend fun findAuthoredChallengesByUser(
        username: String,
        page: Int
    ): ChallengeResponse<AuthoredChallenge> {
        return codeWarsApi.findAuthoredChallengesByUser(username, page).await()
    }
}