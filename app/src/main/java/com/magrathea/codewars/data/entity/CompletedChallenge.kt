package com.magrathea.codewars.data.entity

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

sealed class CompletedChallenge {
    @Entity(indices = [Index(value = ["completedChallengeId"], unique = true)])
    data class LocalCompletedChallenge(
        @PrimaryKey var id: Int,
        var completedChallengeId: String,
        var name: String? = null,
        var slug: String? = null,
        var completedAt: String? = null,
        @TypeConverters var completedLanguages: List<String>? = emptyList(),
    )

    @Parcelize
    data class RemoteCompletedChallenge(
        var id: String,
        var name: String? = null,
        var slug: String? = null,
        var completedAt: String? = null,
        var completedLanguages: List<String>? = emptyList(),
    ) : Parcelable
}
