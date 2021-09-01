package com.magrathea.codewars.data.local.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserWithCompletedChallenges(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userName",
        entityColumn = "id",
        associateBy = Junction(UserCompletedChallengeCrossRef::class)
    )
    val completedChallenges: List<CompletedChallenge>
)
