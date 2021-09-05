package com.magrathea.codewars.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RanksDto(
    var overall: Int? = 0,
    var languages: Map<String, Int>? = emptyMap()
): Parcelable
