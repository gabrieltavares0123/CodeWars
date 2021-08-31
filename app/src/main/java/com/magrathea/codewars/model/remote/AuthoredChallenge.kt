package com.magrathea.codewars.model.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthoredChallenge(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val rank: Int? = null,
    val rankName: String? = null,
    val tags: List<String>? = emptyList(),
    val languages: List<String>? = emptyList(),
) : Parcelable
