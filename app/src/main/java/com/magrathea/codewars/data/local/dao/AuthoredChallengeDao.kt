package com.magrathea.codewars.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.magrathea.codewars.data.local.entity.AuthoredChallengeEntity

@Dao
interface AuthoredChallengeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(authoredChallengeEntity: List<AuthoredChallengeEntity>)

    @Query(value = "SELECT * FROM AuthoredChallengeEntity WHERE userNameAuthor LIKE :username")
    suspend fun allAuthoredChallengesByUserName(username: String): List<AuthoredChallengeEntity>
}