package com.magrathea.codewars.data.local.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Query
import com.magrathea.codewars.data.entity.AuthoredChallenge
import com.magrathea.codewars.data.entity.User
import com.magrathea.codewars.data.entity.UserWithAuthoredChallenges

@Dao
interface AuthoredChallengeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(authoredChallenge: AuthoredChallenge.LocalAuthoredChallenge)

    // TODO: Find a way to filter by user.
    @Transaction
    @Query(value = "SELECT * FROM AuthoredChallenge.LocalAuthoredChallenge")
    suspend fun allAuthoredChallengesByUser(user: User.LocalUser): DataSource.Factory<Int, UserWithAuthoredChallenges>
}