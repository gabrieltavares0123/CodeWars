package com.magrathea.codewars.data.converter

import androidx.room.TypeConverter
import java.util.TreeMap

object MapStringConverter {
    private const val SEPARATOR = ";"
    private const val DIVIDER = "<divider>"

    @TypeConverter
    fun fromMapToString(mp: Map<String, Int>): String {
        val sortedMap = TreeMap(mp)
        return sortedMap.keys.joinToString(SEPARATOR).plus(DIVIDER)
            .plus(sortedMap.values.joinToString(SEPARATOR))
    }

    @TypeConverter
    fun fromStringToMap(str: String): Map<String, Int> {
        str.split("<divider>").run {
            val keys = this.getOrNull(0)?.split(SEPARATOR)
            val values = this.getOrNull(1)?.split(SEPARATOR)?.map { it.toInt() }

            val res = hashMapOf<String, Int>()
            keys?.forEachIndexed { index, s ->
                res[s] = values?.getOrNull(index) ?: 0
            }
            return res
        }
    }
}