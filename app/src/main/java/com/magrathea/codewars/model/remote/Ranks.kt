package com.magrathea.codewars.model.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ranks(
    val overall: Rank? = null,
    val languages: List<Language>? = emptyList()
) : Parcelable