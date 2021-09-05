package com.magrathea.codewars.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ranks(
    val overall: Rank,
    val languages: Map<String, Rank>
) : Parcelable