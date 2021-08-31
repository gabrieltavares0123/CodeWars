package com.magrathea.codewars.data.entity

import android.os.Parcelable
import androidx.room.TypeConverters
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ranks(
    @TypeConverters var overall: Rank? = null,
    var languages: List<Language>? = emptyList()
) : Parcelable