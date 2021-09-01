package com.magrathea.codewars.data.remote.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthoredChallenge(
    var id: String? = null,
    var name: String? = null,
    var description: String? = null,
    var rank: Int? = null,
    var rankName: String? = null,
    var tags: List<String>? = emptyList(),
    var languages: List<String>? = emptyList(),
): Parcelable
