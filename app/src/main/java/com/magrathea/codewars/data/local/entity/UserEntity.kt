package com.magrathea.codewars.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class UserEntity(
    @PrimaryKey var userName: String,
    var name: String? = null,
    var honor: Int? = 0,
    var clan: String? = null,
    var leaderboardPosition: Int? = 0,
    @TypeConverters var skills: List<String>? = emptyList(),
    @Embedded var ranksEntity: RanksEntity? = null,
    @Embedded var bestLanguageEntity: LanguageEntity? = null,
    var searchDate: Long? = null,
)
