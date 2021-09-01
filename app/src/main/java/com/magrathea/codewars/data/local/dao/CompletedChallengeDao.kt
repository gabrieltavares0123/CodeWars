package com.magrathea.codewars.data.local.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.magrathea.codewars.data.entity.CompletedChallenge
import com.magrathea.codewars.data.entity.User
import com.magrathea.codewars.data.entity.UserWithCompletedChallenges

@Dao
interface CompletedChallengeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(completedChallenge: CompletedChallenge.LocalCompletedChallenge)

    // TODO: Find a way to filter by user.
    @Transaction
    @Query(value = "SELECT * FROM CompletedChallenge.LocalCompletedChallenge")
    suspend fun allCompletedChallengesByUserId(user: User.LocalUser): DataSource.Factory<Int, UserWithCompletedChallenges>
}