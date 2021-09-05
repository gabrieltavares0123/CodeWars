package com.magrathea.codewars.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class AuthoredChallenge(
    @PrimaryKey var id: String,
    var name: String? = null,
    var description: String? = null,
    var rank: Int? = null,
    var rankName: String? = null,
    @TypeConverters var tags: List<String>? = emptyList(),
    @TypeConverters var languages: List<String>? = emptyList(),
    var userNameAuthor: String,
) : Parcelable