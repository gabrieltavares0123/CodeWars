package com.magrathea.codewars.data.local.entity

import androidx.room.Entity

@Entity(primaryKeys = ["userName", "id"])
data class UserCompletedChallengeCrossRefEntity(
    val userName: String,
    val id: String
)
