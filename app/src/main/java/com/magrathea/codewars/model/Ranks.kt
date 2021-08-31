package com.magrathea.codewars.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ranks(
    var overall: Rank,
    var languages: List<Language>
) : Parcelable