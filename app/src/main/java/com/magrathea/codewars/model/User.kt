package com.magrathea.codewars.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var userName: String?,
    var name: String?,
    var bestLanguage: Language?,
    var ranks: Ranks?,
    var leaderboardPosition: Int?,
    var searchDate: Long?
) : Parcelable