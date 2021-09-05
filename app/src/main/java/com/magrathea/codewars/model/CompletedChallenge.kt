package com.magrathea.codewars.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class CompletedChallenge(
    @PrimaryKey var id: String,
    var name: String? = null,
    var slug: String? = null,
    var completedAt: String? = null,
    @TypeConverters var completedLanguages: List<String>? = emptyList(),
) : Parcelable