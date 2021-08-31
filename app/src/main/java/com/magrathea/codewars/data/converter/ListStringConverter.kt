package com.magrathea.codewars.data.converter

import androidx.room.TypeConverter

object ListStringConverter {
    private const val SEPARATOR = ";"

    @TypeConverter
    fun fromListToString(lst: List<String>): String {
        return lst.map { it.apply { it + SEPARATOR } }.toString()
    }

    @TypeConverter
    fun fromStringToList(str: String): List<String> {
        return listOf(str.split(SEPARATOR).toString())
    }
}