package com.magrathea.codewars.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.magrathea.codewars.data.local.entity.CompletedChallengeEntity
import com.magrathea.codewars.data.local.entity.UserWithCompletedChallenges

@Dao
interface CompletedChallengeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(completedChallengeEntity: List<CompletedChallengeEntity>)

    @Transaction
    @Query(value = "SELECT * FROM CompletedChallengeEntity, UserCompletedChallengeCrossRefEntity WHERE username= :username")
    fun allCompletedChallengesByUserName(username: String, page: Int): UserWithCompletedChallenges
}