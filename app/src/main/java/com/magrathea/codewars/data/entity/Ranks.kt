package com.magrathea.codewars.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ranks(
    var overall: Rank? = null,
    var languages: List<Language>? = emptyList()
) : Parcelable