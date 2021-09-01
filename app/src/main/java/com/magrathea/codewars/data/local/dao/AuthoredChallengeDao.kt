package com.magrathea.codewars.data.local.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Query
import com.magrathea.codewars.data.entity.AuthoredChallenge
import com.magrathea.codewars.data.entity.UserWithAuthoredChallenges

@Dao
interface AuthoredChallengeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(authoredChallenge: AuthoredChallenge.LocalAuthoredChallenge)

    @Transaction
    @Query(value = "SELECT * FROM AuthoredChallenge.LocalAuthoredChallenge WHERE userAuthorId = :userId")
    suspend fun allAuthoredChallengesByUser(userId: Int): DataSource.Factory<Int, UserWithAuthoredChallenges>
}