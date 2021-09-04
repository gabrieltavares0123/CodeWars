package com.magrathea.codewars.data.mapper

import com.magrathea.codewars.data.local.entity.CompletedChallengeEntity
import com.magrathea.codewars.data.local.entity.UserWithCompletedChallenges
import com.magrathea.codewars.data.remote.entity.CompletedChallengeDto
import com.magrathea.codewars.domain.model.CompletedChallenge

fun List<CompletedChallengeDto>.toCompletedChallengeEntityList(): List<CompletedChallengeEntity> {
    return this.map {
        CompletedChallengeEntity(
            id = it.id,
            name = it.name,
            slug = it.slug,
            completedAt = it.completedAt,
            completedLanguages = it.completedLanguages,
        )
    }
}

fun UserWithCompletedChallenges.toCompletedChallengeDomainList(): List<CompletedChallenge> {
    return this.completedChallengeEntities.map {
        CompletedChallenge(
            id = it.id,
            name = it.name,
            slug = it.slug,
            completedAt = it.completedAt,
            completedLanguages = it.completedLanguages,
        )
    }
}