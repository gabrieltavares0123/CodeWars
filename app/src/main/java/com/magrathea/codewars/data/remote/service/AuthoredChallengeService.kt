package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.CodeWarsApi
import com.magrathea.codewars.data.remote.entity.AuthoredChallenge
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthoredChallengeService @Inject constructor(
    private val codeWarsApi: CodeWarsApi
) {
    suspend fun findAuthoredChallengesByUser(username: String, page: Int): Flow<AuthoredChallenge> {
        return codeWarsApi.findAuthoredChallengesByUser(username, page)
    }
}