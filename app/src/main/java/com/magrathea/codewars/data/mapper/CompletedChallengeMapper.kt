package com.magrathea.codewars.data.mapper

import com.magrathea.codewars.data.local.entity.CompletedChallengeEntity
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

fun List<CompletedChallengeEntity>.toCompletedChallengeDomainList(): List<CompletedChallenge> {
    return this.map {
        CompletedChallenge(
            id = it.id,
            name = it.name,
            slug = it.slug,
            completedAt = it.completedAt,
            completedLanguages = it.completedLanguages,
        )
    }
}