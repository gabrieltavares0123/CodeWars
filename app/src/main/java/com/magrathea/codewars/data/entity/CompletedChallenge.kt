package com.magrathea.codewars.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

sealed class CompletedChallenge {
    @Entity
    data class LocalCompletedChallenge(
        @PrimaryKey(autoGenerate = true) val id: String,
        val name: String,
        val slug: String,
        val completedAt: String,
        val completedLanguages: List<String> = emptyList(),
    )

    @Parcelize
    data class RemoteCompletedChallenge(
        val id: String,
        val name: String,
        val slug: String,
        val completedAt: String,
        val completedLanguages: List<String> = emptyList(),
    ) : Parcelable
}
