package com.magrathea.codewars.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Query
import com.magrathea.codewars.data.local.entity.AuthoredChallenge
import com.magrathea.codewars.data.local.entity.UserWithAuthoredChallenges

@Dao
interface AuthoredChallengeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(authoredChallenge: AuthoredChallenge)

    // TODO: Find a way to filter by username.
    @Transaction
    @Query(value = "SELECT * FROM AuthoredChallenge")
    fun allAuthoredChallengesByUserName(): PagingSource<Int, UserWithAuthoredChallenges>
}