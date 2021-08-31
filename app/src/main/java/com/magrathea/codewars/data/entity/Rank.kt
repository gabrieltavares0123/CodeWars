package com.magrathea.codewars.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rank(
    var score: Int? = 0
) : Parcelable