package com.magrathea.codewars.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Language(
    var name: String,
    var rank: Rank
) : Parcelable