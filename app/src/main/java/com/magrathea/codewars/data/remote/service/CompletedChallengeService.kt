package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.CodeWarsApi
import com.magrathea.codewars.data.remote.entity.CompletedChallenge
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CompletedChallengeService @Inject constructor(
    private val codeWarsApi: CodeWarsApi
) {
    companion object {
        private const val DEFAULT_PAGE_SIZE = 50
    }

    suspend fun findCompletedChallengesByUser(username: String, page: Int): Flow<CompletedChallenge> {
        return codeWarsApi.findCompletedChallengesByUser(username, page = DEFAULT_PAGE_SIZE)
    }
}