package com.magrathea.codewars.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ranks(
    val overall: Rank? = null,
    val languages: List<Language>? = emptyList()
) : Parcelable