package com.magrathea.codewars.model.remote

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val userName: String? = null,
    val name: String? = null,
    val honor: Int? = 0,
    val clan: String? = null,
    val leaderboardPosition: Int?,
    val skills: List<String>? = emptyList(),
    val ranks: Ranks? = null,
) : Parcelable {
    @IgnoredOnParcel
    val bestLanguage: Language? = null

    @IgnoredOnParcel
    val searchDate: Long? = null
}