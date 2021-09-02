package com.magrathea.codewars.domain.repository

import com.magrathea.codewars.domain.model.AuthoredChallenge

interface AuthoredChallengeRepository {
    suspend fun findAuthoredChallengesByUser(username: String, page: Int): List<AuthoredChallenge>
}