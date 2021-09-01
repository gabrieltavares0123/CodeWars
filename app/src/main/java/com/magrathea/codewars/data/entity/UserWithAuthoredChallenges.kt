package com.magrathea.codewars.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithAuthoredChallenges(
    @Embedded val user: User,
    @Relation(parentColumn = "userId", entityColumn = "userAuthorId")
    val authoredChallenges: List<AuthoredChallenge>
)
