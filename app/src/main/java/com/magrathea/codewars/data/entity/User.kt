package com.magrathea.codewars.data.entity

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

sealed class User {
    @Entity(indices = [Index(value = ["userName"], unique = true)])
    data class LocalUser(
        @PrimaryKey var userId: Int,
        var userName: String,
        var name: String? = null,
        var honor: Int? = 0,
        var clan: String? = null,
        var leaderboardPosition: Int? = 0,
        @TypeConverters var skills: List<String>? = emptyList(),
        @Embedded var ranks: Ranks.LocalRanks? = null,
        @Embedded var bestLanguage: Language? = null,
        var searchDate: Long? = null,
    ): User()

    @Parcelize
    data class RemoteUser(
        var userName: String? = null,
        var name: String? = null,
        var honor: Int? = 0,
        var clan: String? = null,
        var leaderboardPosition: Int? = 0,
        var skills: List<String>? = emptyList(),
        var ranks: Ranks.RemoteRanks? = null,
    ): User(), Parcelable
}