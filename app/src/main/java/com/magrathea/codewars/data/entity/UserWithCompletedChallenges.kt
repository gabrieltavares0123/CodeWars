package com.magrathea.codewars.data.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserWithCompletedChallenges(
    @Embedded val user: User.LocalUser,
    @Relation(parentColumn = "userId", entityColumn = "id", associateBy = Junction(UserCompletedChallengeCrossRef::class))
    val completedChallenges: List<CompletedChallenge.LocalCompletedChallenge>
)
