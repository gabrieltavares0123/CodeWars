package com.magrathea.codewars.data.local.entity

import androidx.room.TypeConverters

data class RanksEntity(
    var overall: Int? = 0,
    @TypeConverters var languages: Map<String, Int>? = emptyMap()
)