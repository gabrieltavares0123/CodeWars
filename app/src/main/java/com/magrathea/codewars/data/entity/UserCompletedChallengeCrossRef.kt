package com.magrathea.codewars.data.entity

import androidx.room.Entity

@Entity(primaryKeys = ["userId", "id"])
data class UserCompletedChallengeCrossRef(
    val userId: Int,
    val id: Int
)
