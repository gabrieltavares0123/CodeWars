package com.magrathea.codewars.domain.repository

import com.magrathea.codewars.domain.model.CompletedChallenge

interface CompletedChallengeRepository {
    suspend fun findCompletedChallengesByUser(username: String, page: Int): List<CompletedChallenge>
}