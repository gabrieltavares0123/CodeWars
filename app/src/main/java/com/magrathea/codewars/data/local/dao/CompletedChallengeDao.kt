package com.magrathea.codewars.data.local.dao

import androidx.room.*
import com.magrathea.codewars.model.CompletedChallenge

@Dao
interface CompletedChallengeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(completedChallenge: List<CompletedChallenge>)

    @Transaction
    @Query(
        value = "SELECT cc.id, cc.name, cc.completedAt " +
                "FROM CompletedChallenge AS cc " +
                "INNER JOIN UserCompletedChallengeCrossRef AS crossRef " +
                "    ON cc.id = crossRef.id " +
                "INNER JOIN User AS user " +
                "    ON crossRef.userName = user.userName " +
                "WHERE crossRef.username = :username"
    )
    suspend fun allCompletedChallengesByUserName(username: String): List<CompletedChallenge>
}