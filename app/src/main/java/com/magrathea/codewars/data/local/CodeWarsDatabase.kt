package com.magrathea.codewars.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.magrathea.codewars.data.converter.ListStringConverter
import com.magrathea.codewars.data.local.dao.AuthoredChallengeDao
import com.magrathea.codewars.data.local.dao.CompletedChallengeDao
import com.magrathea.codewars.data.local.dao.UserDao
import com.magrathea.codewars.model.AuthoredChallenge
import com.magrathea.codewars.model.CompletedChallenge
import com.magrathea.codewars.model.User
import com.magrathea.codewars.model.UserCompletedChallengeCrossRef

@Database(
    entities = [
        User::class,
        AuthoredChallenge::class,
        CompletedChallenge::class,
        UserCompletedChallengeCrossRef::class,
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(
    value = [
        ListStringConverter::class,
    ]
)
abstract class CodeWarsDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun authoredChallengeDao(): AuthoredChallengeDao
    abstract fun completedChallengeDao(): CompletedChallengeDao
}