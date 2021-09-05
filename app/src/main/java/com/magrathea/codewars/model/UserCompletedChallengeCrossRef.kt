package com.magrathea.codewars.model

import androidx.room.Entity

@Entity(primaryKeys = ["userName", "id"])
data class UserCompletedChallengeCrossRef(
    val userName: String,
    val id: String
)
