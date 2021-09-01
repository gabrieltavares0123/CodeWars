package com.magrathea.codewars.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithAuthoredChallenges(
    @Embedded val userEntity: UserEntity,
    @Relation(parentColumn = "userName", entityColumn = "userNameAuthor")
    val authoredChallengeEntities: List<AuthoredChallengeEntity>
)
