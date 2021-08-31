package com.magrathea.codewars.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Language(
    val name: String? = null,
    val  rank: Rank? = null,
) : Parcelable