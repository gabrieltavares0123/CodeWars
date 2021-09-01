package com.magrathea.codewars.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.magrathea.codewars.data.local.entity.CompletedChallenge
import com.magrathea.codewars.data.local.entity.UserWithCompletedChallenges

@Dao
interface CompletedChallengeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(completedChallenge: CompletedChallenge)

    @Transaction
    @Query(value = "SELECT * FROM CompletedChallenge")
    fun allCompletedChallengesByUserName(username: String): PagingSource<Int, UserWithCompletedChallenges>
}