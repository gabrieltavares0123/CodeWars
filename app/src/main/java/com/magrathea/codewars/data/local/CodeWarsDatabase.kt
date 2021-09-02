package com.magrathea.codewars.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.magrathea.codewars.data.converter.ListStringConverter
import com.magrathea.codewars.data.converter.MapStringConverter
import com.magrathea.codewars.data.local.dao.AuthoredChallengeDao
import com.magrathea.codewars.data.local.dao.UserDao
import com.magrathea.codewars.data.local.entity.*

@Database(
    entities = [
        UserEntity::class,
        AuthoredChallengeEntity::class,
        CompletedChallengeEntity::class,
        UserCompletedChallengeCrossRefEntity::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [
        ListStringConverter::class,
        MapStringConverter::class,
    ]
)
abstract class CodeWarsDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun authoredChallengeDao(): AuthoredChallengeDao
}