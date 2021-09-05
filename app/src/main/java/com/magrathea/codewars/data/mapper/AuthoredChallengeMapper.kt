package com.magrathea.codewars.data.mapper

import com.magrathea.codewars.data.local.entity.AuthoredChallengeEntity
import com.magrathea.codewars.data.remote.dto.AuthoredChallengeDto
import com.magrathea.codewars.domain.model.AuthoredChallenge

fun List<AuthoredChallengeDto>.toAuthoredChallengeEntityList(username: String): List<AuthoredChallengeEntity> {
    return this.map {
        AuthoredChallengeEntity(
            id = it.id,
            name = it.name,
            description = it.description,
            rank = it.rank,
            tags = it.tags,
            languages = it.languages,
            userNameAuthor = username,
        )
    }
}

fun List<AuthoredChallengeEntity>.toAuthoredChallengeDomainList(): List<AuthoredChallenge> {
    return this.map {
        AuthoredChallenge(
            id = it.id,
            name = it.name,
            description = it.description,
            rank = it.rank,
            rankName = it.rankName,
            tags = it.tags,
            languages = it.languages,
        )
    }
}