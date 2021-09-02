package com.magrathea.codewars.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class CompletedChallengeEntity(
    @PrimaryKey var id: String,
    var name: String? = null,
    var slug: String? = null,
    var completedAt: String? = null,
    @TypeConverters var completedLanguages: List<String>? = emptyList(),
)