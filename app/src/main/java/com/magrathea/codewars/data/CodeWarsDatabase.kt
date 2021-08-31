package com.magrathea.codewars.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [])
abstract class CodeWarsDatabase : RoomDatabase() {
}