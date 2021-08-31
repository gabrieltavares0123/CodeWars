package com.magrathea.codewars.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Language(
    var name: String? = null,
    var  rank: Rank? = null,
) : Parcelable