package com.magrathea.codewars.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class AuthoredChallenge(
    @PrimaryKey val id: String,
    val name: String? = null,
    val description: String? = null,
    val rank: Int? = null,
    val rankName: String? = null,
    @TypeConverters val tags: List<String>? = emptyList(),
    @TypeConverters val languages: List<String>? = emptyList(),
    val userNameAuthor: String,
) : Parcelable