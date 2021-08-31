package com.magrathea.codewars.data.converter

import androidx.room.TypeConverter

object RankStringConverter {
    @TypeConverter
    fun fromRankToString(rank: Rank): String {
        return rank.score.toString()
    }

    @TypeConverter
    fun fromStringToRank(str: String): Rank {
        return Rank(score = str.toInt())
    }
}