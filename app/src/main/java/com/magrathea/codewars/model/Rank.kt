package com.magrathea.codewars.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rank(
    var score: Int
) : Parcelable