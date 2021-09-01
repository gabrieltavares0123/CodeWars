package com.magrathea.codewars.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class User(
    @PrimaryKey var userName: String,
    var name: String? = null,
    var honor: Int? = 0,
    var clan: String? = null,
    var leaderboardPosition: Int? = 0,
    @TypeConverters var skills: List<String>? = emptyList(),
    @Embedded var ranks: Ranks? = null,
    @Embedded var bestLanguage: Language? = null,
    var searchDate: Long? = null,
)
