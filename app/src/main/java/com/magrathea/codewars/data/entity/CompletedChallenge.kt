package com.magrathea.codewars.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.parcelize.Parcelize

sealed class CompletedChallenge {
    @Entity
    data class LocalCompletedChallenge(
        @PrimaryKey(autoGenerate = true) val id: String,
        var name: String,
        var slug: String,
        var completedAt: String,
        @TypeConverters var completedLanguages: List<String> = emptyList(),
    )

    @Parcelize
    data class RemoteCompletedChallenge(
        var id: String,
        var name: String,
        var slug: String,
        var completedAt: String,
        var completedLanguages: List<String> = emptyList(),
    ) : Parcelable
}
