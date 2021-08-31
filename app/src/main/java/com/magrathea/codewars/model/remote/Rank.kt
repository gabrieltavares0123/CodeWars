package com.magrathea.codewars.model.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rank(
    val score: Int? = 0
) : Parcelable