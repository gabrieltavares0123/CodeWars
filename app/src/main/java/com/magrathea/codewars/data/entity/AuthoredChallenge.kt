package com.magrathea.codewars.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.parcelize.Parcelize

sealed class AuthoredChallenge {
    @Entity
    data class LocalAuthoredChallenge(
        @PrimaryKey(autoGenerate = true) var id: String? = null,
        var name: String? = null,
        var description: String? = null,
        var rank: Int? = null,
        var rankName: String? = null,
        @TypeConverters var tags: List<String>? = emptyList(),
        @TypeConverters var languages: List<String>? = emptyList(),
    )

    @Parcelize
    data class RemoteAuthoredChallenge(
        var id: String? = null,
        var name: String? = null,
        var description: String? = null,
        var rank: Int? = null,
        var rankName: String? = null,
        var tags: List<String>? = emptyList(),
        var languages: List<String>? = emptyList(),
    ) : AuthoredChallenge(), Parcelable
}
