package com.magrathea.codewars.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class Ranks(
    @PrimaryKey(autoGenerate = true) var ranksId: Int,
    var overall: Int? = 0,
    @TypeConverters var languages: Map<String, Int>? = emptyMap()
)