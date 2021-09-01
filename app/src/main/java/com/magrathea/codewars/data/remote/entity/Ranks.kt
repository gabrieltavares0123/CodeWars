package com.magrathea.codewars.data.remote.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ranks(
    var overall: Int? = 0,
    var languages: Map<String, Int>? = emptyMap()
): Parcelable
