package com.magrathea.codewars.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class AuthoredChallengeEntity(
    @PrimaryKey var id: String,
    var name: String? = null,
    var description: String? = null,
    var rank: Int? = null,
    var rankName: String? = null,
    @TypeConverters var tags: List<String>? = emptyList(),
    @TypeConverters var languages: List<String>? = emptyList(),
    var userNameAuthor: String,
)