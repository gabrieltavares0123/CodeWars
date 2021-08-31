package com.magrathea.codewars.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Language(
    @PrimaryKey var name: String? = null,
    var rank: Int? = 0,
)