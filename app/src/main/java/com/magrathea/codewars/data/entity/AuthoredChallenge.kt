package com.magrathea.codewars.data.entity

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

sealed class AuthoredChallenge {
    @Entity(indices = [Index(value = ["authoredChallengeId"], unique = true)])
    data class LocalAuthoredChallenge(
        @PrimaryKey(autoGenerate = true) var id: Int,
        var authoredChallengeId: String,
        var name: String? = null,
        var description: String? = null,
        var rank: Int? = null,
        var rankName: String? = null,
        @TypeConverters var tags: List<String>? = emptyList(),
        @TypeConverters var languages: List<String>? = emptyList(),
        var userAuthorId: Int,
    ): AuthoredChallenge()

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
