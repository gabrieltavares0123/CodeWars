package com.magrathea.codewars.data.local.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserWithCompletedChallenges(
    @Embedded val userEntity: UserEntity,
    @Relation(
        parentColumn = "userName",
        entityColumn = "id",
        associateBy = Junction(UserCompletedChallengeCrossRefEntity::class)
    )
    val completedChallengeEntities: List<CompletedChallengeEntity>
)
