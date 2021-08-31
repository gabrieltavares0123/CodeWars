package com.magrathea.codewars.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.magrathea.codewars.data.converter.ListStringConverter
import com.magrathea.codewars.data.entity.AuthoredChallenge
import com.magrathea.codewars.data.entity.CompletedChallenge
import com.magrathea.codewars.data.entity.User

@Database(
    entities = [
        User.LocalUser::class,
        AuthoredChallenge.LocalAuthoredChallenge::class,
        CompletedChallenge.LocalCompletedChallenge::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [
        ListStringConverter::class,
    ]
)
abstract class CodeWarsDatabase : RoomDatabase() {
}