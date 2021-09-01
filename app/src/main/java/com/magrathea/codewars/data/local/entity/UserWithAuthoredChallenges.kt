package com.magrathea.codewars.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithAuthoredChallenges(
    @Embedded val user: User,
    @Relation(parentColumn = "userName", entityColumn = "userNameAuthor")
    val authoredChallenges: List<AuthoredChallenge>
)
