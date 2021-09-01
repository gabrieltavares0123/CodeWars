package com.magrathea.codewars.data.remote.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var userName: String? = null,
    var name: String? = null,
    var honor: Int? = 0,
    var clan: String? = null,
    var leaderboardPosition: Int? = 0,
    var skills: List<String>? = emptyList(),
    var ranks: Ranks? = null,
): Parcelable