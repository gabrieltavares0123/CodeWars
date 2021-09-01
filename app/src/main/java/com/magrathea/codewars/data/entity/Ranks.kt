package com.magrathea.codewars.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.parcelize.Parcelize

sealed class Ranks {
    @Entity
    data class LocalRanks(
        @PrimaryKey(autoGenerate = true) var ranksId: Int,
        var overall: Int? = 0,
        @TypeConverters var languages: Map<String, Int>? = emptyMap()
    )

    @Parcelize
    data class RemoteRanks(
        var overall: Int? = 0,
        var languages: Map<String, Int>? = emptyMap()
    ) : Parcelable
}
