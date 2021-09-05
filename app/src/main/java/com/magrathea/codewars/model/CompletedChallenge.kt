package com.magrathea.codewars.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class CompletedChallenge(
    @PrimaryKey val id: String,
    val name: String? = null,
    val slug: String? = null,
    val completedAt: String? = null,
    @TypeConverters val completedLanguages: List<String>? = emptyList(),
) : Parcelable