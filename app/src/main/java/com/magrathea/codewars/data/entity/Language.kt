package com.magrathea.codewars.data.entity

import androidx.room.Entity

@Entity
data class Language(
    var languageName: String,
    var rank: Int? = 0,
)