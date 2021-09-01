package com.magrathea.codewars.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Language(
    @PrimaryKey(autoGenerate = true) var languageId: Int,
    var languageName: String,
    var rank: Int? = 0,
)