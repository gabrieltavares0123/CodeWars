package com.magrathea.codewars.data.entity

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

sealed class User {
    @Entity
    data class LocalUser(
        @PrimaryKey(autoGenerate = true) var userName: String? = null,
        var name: String? = null,
        var honor: Int? = 0,
        var clan: String? = null,
        var leaderboardPosition: Int? = 0,
        var skills: List<String>? = emptyList(),
        @Embedded var ranks: Ranks? = null,
        @Embedded var bestLanguage: Language? = null,
        var searchDate: Long? = null,
    )

    @Parcelize
    data class RemoteUser(
        var userName: String? = null,
        var name: String? = null,
        var honor: Int? = 0,
        var clan: String? = null,
        var leaderboardPosition: Int? = 0,
        var skills: List<String>? = emptyList(),
        var ranks: Ranks? = null,
    ) : Parcelable
}