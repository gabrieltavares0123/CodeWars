package com.magrathea.codewars.data.entity

import android.os.Parcelable
import androidx.room.TypeConverters
import kotlinx.parcelize.Parcelize

@Parcelize
data class Language(
    var name: String? = null,
    var rank: Int? = 0,
) : Parcelable