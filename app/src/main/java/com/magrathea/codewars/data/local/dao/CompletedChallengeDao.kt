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
    @Query(
        value = "SELECT cc.id, cc.name, cc.completedAt " +
                "FROM CompletedChallengeEntity AS cc " +
                "INNER JOIN UserCompletedChallengeCrossRefEntity AS crossRef " +
                "    ON cc.id = crossRef.id " +
                "INNER JOIN UserEntity AS user " +
                "    ON crossRef.userName = user.userName " +
                "WHERE crossRef.username = :username"
    )
    suspend fun allCompletedChallengesByUserName(username: String): List<CompletedChallengeEntity>
}