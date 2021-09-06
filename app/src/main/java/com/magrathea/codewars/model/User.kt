package com.magrathea.codewars.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class User(
    @PrimaryKey
    val username: String,
    val name: String?,
    val honor: Int,
    val leaderboardPosition: Int,
) : Parcelable {
    @Ignore
    @IgnoredOnParcel
    var realUserName = name ?: username

    @Ignore
    @IgnoredOnParcel
    var ranks: Ranks? = null

    @Embedded
    @IgnoredOnParcel
    var bestLanguage: BestLanguage? = null

    @IgnoredOnParcel
    var searchDate: Long? = null
}
