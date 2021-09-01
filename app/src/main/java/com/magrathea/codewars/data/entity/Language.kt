package com.magrathea.codewars.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Language(
    @PrimaryKey(autoGenerate = true) var languageId: Int,
    var languageName: String,
    var rank: Int? = 0,
)